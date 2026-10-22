package ai.onnxruntime.providers;

import ai.onnxruntime.OrtProvider;
import ai.onnxruntime.OrtProviderOptions;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OrtTensorRTProviderOptions extends StringConfigProviderOptions {
    private static final OrtProvider PROVIDER = OrtProvider.TENSOR_RT;

    public OrtTensorRTProviderOptions() {
        this(0);
    }

    private static native long create(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long lambda$new$0() {
        return create(OrtProviderOptions.getApiHandle());
    }

    @Override // ai.onnxruntime.providers.StringConfigProviderOptions
    public native void add(long j10, long j11, String str, String str2);

    @Override // ai.onnxruntime.providers.StringConfigProviderOptions
    public /* bridge */ /* synthetic */ void add(String str, String str2) {
        super.add(str, str2);
    }

    @Override // ai.onnxruntime.OrtProviderOptions
    public native void close(long j10, long j11);

    @Override // ai.onnxruntime.providers.StringConfigProviderOptions
    public /* bridge */ /* synthetic */ String getOptionsString() {
        return super.getOptionsString();
    }

    @Override // ai.onnxruntime.OrtProviderOptions
    public OrtProvider getProvider() {
        return PROVIDER;
    }

    @Override // ai.onnxruntime.providers.StringConfigProviderOptions
    public /* bridge */ /* synthetic */ void parseOptionsString(String str) {
        super.parseOptionsString(str);
    }

    @Override // ai.onnxruntime.providers.StringConfigProviderOptions
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public OrtTensorRTProviderOptions(int i10) {
        super(OrtProviderOptions.loadLibraryAndCreate(PROVIDER, new a0.a(9)));
        if (i10 < 0) {
            close();
            throw new IllegalArgumentException(a.a(i10, "Device id must be non-negative, received "));
        }
        String strA = a.a(i10, "");
        this.options.put("device_id", strA);
        add(OrtProviderOptions.getApiHandle(), this.nativeHandle, "device_id", strA);
    }
}
