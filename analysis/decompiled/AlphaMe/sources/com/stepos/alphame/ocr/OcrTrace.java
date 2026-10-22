package com.stepos.alphame.ocr;

import android.os.SystemClock;
import android.util.Log;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.joran.action.Action;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0003J\u0016\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\u0018J\u0006\u0010%\u001a\u00020\u0018J\u000e\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u0006J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0006J\u0006\u0010*\u001a\u00020\u0018J\u001e\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\fJ\u0006\u0010/\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/stepos/alphame/ocr/OcrTrace;", "", "api", "", "(Ljava/lang/String;)V", "bmpH", "", "bmpW", "boxes", "jsonLen", Action.KEY_ATTRIBUTE, "merged", "", "queueDepth", "t0", "", "tDecoded", "tDecoderReady", "tGatePassed", "tMapped", "tNativeDone", "tNativeSubmit", "tReinit", "appendStage", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "name", "from", "to", "dump", "result", "markDecoded", "width", "height", "markDecoderReady", "markGatePassed", "markMapped", "jsonLength", "markNativeDone", "boxCount", "markNativeSubmit", "markQueued", "requestKey", "depth", "mergedIntoExisting", "markReinit", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nOcrTrace.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrTrace.kt\ncom/stepos/alphame/ocr/OcrTrace\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,159:1\n1#2:160\n*E\n"})
/* loaded from: classes.dex */
public final class OcrTrace {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "OcrTrace";
    private static volatile boolean enabled;

    @NotNull
    private final String api;
    private int bmpH;
    private int bmpW;
    private int boxes;
    private int jsonLen;

    @Nullable
    private String key;
    private boolean merged;
    private int queueDepth;
    private final long t0;
    private long tDecoded;
    private long tDecoderReady;
    private long tGatePassed;
    private long tMapped;
    private long tNativeDone;
    private long tNativeSubmit;
    private long tReinit;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/alphame/ocr/OcrTrace$Companion;", "", "()V", "TAG", "", "enabled", "", "getEnabled$annotations", "getEnabled", "()Z", "setEnabled", "(Z)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getEnabled$annotations() {
        }

        public final boolean getEnabled() {
            return OcrTrace.enabled;
        }

        public final void setEnabled(boolean z4) {
            OcrTrace.enabled = z4;
        }
    }

    public OcrTrace(@NotNull String api) {
        Intrinsics.checkNotNullParameter(api, "api");
        this.api = api;
        this.t0 = SystemClock.elapsedRealtime();
        this.boxes = -1;
        this.jsonLen = -1;
        this.queueDepth = -1;
    }

    private final void appendStage(StringBuilder sb, String name, long from, long to) {
        if (from <= 0 || to <= 0 || to < from) {
            return;
        }
        sb.append(' ');
        sb.append(name);
        sb.append('=');
        sb.append(to - from);
    }

    public static final boolean getEnabled() {
        return INSTANCE.getEnabled();
    }

    public static final void setEnabled(boolean z4) {
        INSTANCE.setEnabled(z4);
    }

    public final void dump(@NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (enabled) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder(220);
            sb.append("api=");
            AbstractC0351g.C(sb, this.api, " result=", result, " total=");
            sb.append(jElapsedRealtime - this.t0);
            sb.append("ms |");
            appendStage(sb, "source", this.t0, this.tDecoderReady);
            appendStage(sb, "gate", this.tDecoderReady, this.tGatePassed);
            appendStage(sb, "reinit", this.tGatePassed, this.tReinit);
            long j4 = this.tReinit;
            if (j4 <= 0) {
                j4 = this.tGatePassed;
            }
            appendStage(sb, "decode", j4, this.tDecoded);
            appendStage(sb, "submit", this.tDecoded, this.tNativeSubmit);
            appendStage(sb, "native", this.tNativeSubmit, this.tNativeDone);
            appendStage(sb, "map", this.tNativeDone, this.tMapped);
            appendStage(sb, "bcast", this.tMapped, jElapsedRealtime);
            sb.append(" |");
            if (this.bmpW > 0) {
                sb.append(" bmp=");
                sb.append(this.bmpW);
                sb.append('x');
                sb.append(this.bmpH);
                sb.append(" px=");
                sb.append((this.bmpW * this.bmpH) / 1000);
                sb.append('k');
            }
            if (this.boxes >= 0) {
                sb.append(" boxes=");
                sb.append(this.boxes);
            }
            if (this.jsonLen >= 0) {
                sb.append(" json=");
                sb.append(this.jsonLen);
            }
            if (this.boxes > 0 && this.tNativeDone > this.tNativeSubmit) {
                sb.append(" perBoxNative=");
                sb.append((this.tNativeDone - this.tNativeSubmit) / this.boxes);
                sb.append("ms");
            }
            if (this.queueDepth >= 0) {
                sb.append(" qdepth=");
                sb.append(this.queueDepth);
            }
            if (this.merged) {
                sb.append(" merged=1");
            }
            String str = this.key;
            if (str != null) {
                sb.append(" key=");
                sb.append(str);
            }
            Log.i(TAG, sb.toString());
        }
    }

    public final void markDecoded(int width, int height) {
        this.tDecoded = SystemClock.elapsedRealtime();
        this.bmpW = width;
        this.bmpH = height;
    }

    public final void markDecoderReady() {
        this.tDecoderReady = SystemClock.elapsedRealtime();
    }

    public final void markGatePassed() {
        this.tGatePassed = SystemClock.elapsedRealtime();
    }

    public final void markMapped(int jsonLength) {
        this.tMapped = SystemClock.elapsedRealtime();
        this.jsonLen = jsonLength;
    }

    public final void markNativeDone(int boxCount) {
        this.tNativeDone = SystemClock.elapsedRealtime();
        this.boxes = boxCount;
    }

    public final void markNativeSubmit() {
        this.tNativeSubmit = SystemClock.elapsedRealtime();
    }

    public final void markQueued(@NotNull String requestKey, int depth, boolean mergedIntoExisting) {
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        this.key = requestKey;
        this.queueDepth = depth;
        this.merged = mergedIntoExisting;
    }

    public final void markReinit() {
        this.tReinit = SystemClock.elapsedRealtime();
    }
}
