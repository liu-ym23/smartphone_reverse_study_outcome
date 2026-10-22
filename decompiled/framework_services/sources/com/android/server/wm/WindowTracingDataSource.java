package com.android.server.wm;

import android.tracing.perfetto.CreateTlsStateArgs;
import android.tracing.perfetto.DataSource;
import android.tracing.perfetto.DataSourceInstance;
import android.tracing.perfetto.DataSourceParams;
import android.tracing.perfetto.InitArguments;
import android.tracing.perfetto.Producer;
import android.util.Log;
import android.util.proto.ProtoInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class WindowTracingDataSource extends DataSource<Instance, TlsState, Void> {
    private static final Config CONFIG_DEFAULT = null;
    private static final int CONFIG_VALUE_UNSPECIFIED = 0;
    private static final String TAG = "WindowTracingDataSource";
    private final WeakReference<WindowTracingPerfetto> mWindowTracing;

    public static class Config {
        public final int mLogFrequency;
        public final int mLogLevel;

        /* synthetic */ Config(int r1, int r2, WindowTracingDataSourceIA r3) {
            this(r1, r2);
        }

        private Config(int logLevel, int logFrequency) {
            this.mLogLevel = logLevel;
            this.mLogFrequency = logFrequency;
        }
    }

    public static abstract class Instance extends DataSourceInstance {
        public final Config mConfig;

        public Instance(DataSource dataSource, int instanceIndex, Config config) {
            super(dataSource, instanceIndex);
            this.mConfig = config;
        }
    }

    public static class TlsState {
        public final Config mConfig;
        public final AtomicBoolean mIsStarting;

        /* synthetic */ TlsState(Config r1, WindowTracingDataSourceIA r2) {
            this(r1);
        }

        private TlsState(Config config) {
            this.mIsStarting = new AtomicBoolean(true);
            this.mConfig = config;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWindowTracing, reason: not valid java name */
    static /* bridge */ /* synthetic */ WeakReference m10483$$Nest$fgetmWindowTracing(WindowTracingDataSource r0) {
        return r0.mWindowTracing;
    }

    public /* bridge */ /* synthetic */ DataSourceInstance createInstance(ProtoInputStream r1, int r2) {
        return m10484createInstance(r1, r2);
    }

    /* JADX INFO: renamed from: createTlsState, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10485createTlsState(CreateTlsStateArgs r1) {
        return createTlsState(r1);
    }

    static {
        int r3 = 1;
        CONFIG_DEFAULT = new Config(r3, 0, null);
    }

    public WindowTracingDataSource(WindowTracingPerfetto windowTracing, String dataSourceName) {
        super(dataSourceName);
        this.mWindowTracing = new WeakReference(windowTracing);
        Producer.init(InitArguments.DEFAULTS);
        DataSourceParams params = new DataSourceParams.Builder().setBufferExhaustedPolicy(1).build();
        register(params);
        Log.i(TAG, "Registered with perfetto service");
    }

    /* JADX INFO: renamed from: createInstance, reason: collision with other method in class */
    public Instance m10484createInstance(ProtoInputStream configStream, final int instanceIndex) {
        Config config = parseDataSourceConfig(configStream);
        if (config == null) goto L5;
        final Config r2 = config;
    L7:
        return new AnonymousClass1(this, this, instanceIndex, r2);
    L5:
        r2 = CONFIG_DEFAULT;
        goto L7
    }

    public TlsState createTlsState(CreateTlsStateArgs<Instance> args) {
        Instance dsInstance = (Instance) args.getDataSourceInstanceLocked();
        WindowTracingDataSourceIA r1 = null;
        if (dsInstance != null) goto L10;
        TlsState r2 = new TlsState(CONFIG_DEFAULT, r1);     // Catch: Throwable -> L8
        if (dsInstance == null) goto L7;
        dsInstance.close();
    L7:
        return r2;
    L10:
        TlsState r3 = new TlsState(dsInstance.mConfig, r1);     // Catch: Throwable -> L8
        dsInstance.close();
        return r3;
    L8:
        th = move-exception;
        if (dsInstance != null) goto L20;
    L18:
        throw th;
    L20:
        dsInstance.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);
        goto L18
    }

    private Config parseDataSourceConfig(ProtoInputStream stream) {
    L16:
    L9:
        e = move-exception;
        throw new RuntimeException("Failed to parse DataSourceConfig", e);
    L3:
        if (stream.nextField() == (-1)) goto L11;
        if (stream.getFieldNumber() != 130) goto L16;
        return parseWindowManagerConfig(stream);
    L11:
        Log.w(TAG, "Received start request without config parameters. Will use defaults.");     // Catch: IOException -> L9
        return null;
    }

    private Config parseWindowManagerConfig(ProtoInputStream stream) {
        int parsedLogLevel = 0;
        int parsedLogFrequency = 0;
        long token = stream.start(1146756268162L);     // Catch: IOException -> L10
    L6:
        if (stream.nextField() == (-1)) goto L14;
        switch(stream.getFieldNumber()) {
            case 1: goto L13;
            case 2: goto L12;
            default: goto L9;
        };     // Catch: IOException -> L10
    L12:
        parsedLogLevel = stream.readInt(1159641169922L);     // Catch: IOException -> L10
        goto L6
    L13:
        parsedLogFrequency = stream.readInt(1159641169921L);     // Catch: IOException -> L10
        goto L6
    L9:
        Log.w(TAG, "Unrecognized WindowManagerConfig field number: " + stream.getFieldNumber());     // Catch: IOException -> L10
        goto L6
    L14:
        stream.end(token);     // Catch: IOException -> L10
        switch(parsedLogLevel) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            default: goto L16;
        };
    L16:
        Log.w(TAG, "Unrecognized log level. Defaulting to TRIM");
        int logLevel = 1;
    L21:
        switch(parsedLogFrequency) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        Log.w(TAG, "Unrecognized log frequency. Defaulting to 'frame'");
        int logFrequency = 0;
    L28:
        return new Config(logLevel, logFrequency, null);
    L23:
        logFrequency = 2;
        goto L28
    L24:
        logFrequency = 1;
        goto L28
    L25:
        logFrequency = 0;
        goto L28
    L26:
        Log.w(TAG, "Unspecified log frequency. Defaulting to 'frame'");
        logFrequency = 0;
        goto L28
    L17:
        logLevel = 2;
        goto L21
    L18:
        logLevel = 1;
        goto L21
    L19:
        logLevel = 0;
        goto L21
    L20:
        Log.w(TAG, "Unspecified log level. Defaulting to TRIM");
        logLevel = 1;
    L10:
        e = move-exception;
        throw new RuntimeException("Failed to parse WindowManagerConfig", e);
    }
}
