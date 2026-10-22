package io.modelcontextprotocol.kotlin.sdk;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0002\u000f\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ProgressBase;", "", "", "getProgress", "()I", "progress", "", "getTotal", "()Ljava/lang/Double;", "total", "", "getMessage", "()Ljava/lang/String;", "message", "Companion", "Lio/modelcontextprotocol/kotlin/sdk/Progress;", "Lio/modelcontextprotocol/kotlin/sdk/ProgressNotification;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public interface ProgressBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ProgressBase$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ProgressBase;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<ProgressBase> serializer() {
            return new lb.j("io.modelcontextprotocol.kotlin.sdk.ProgressBase", kotlin.jvm.internal.t.b(ProgressBase.class), new InterfaceC5745d[]{kotlin.jvm.internal.t.b(Progress.class), kotlin.jvm.internal.t.b(ProgressNotification.class)}, new KSerializer[]{Progress$$serializer.INSTANCE, ProgressNotification$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    String getMessage();

    int getProgress();

    Double getTotal();
}
