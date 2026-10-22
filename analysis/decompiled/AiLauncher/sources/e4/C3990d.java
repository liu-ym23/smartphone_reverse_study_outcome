package e4;

import com.autonavi.aps.amapapi.config.Const;
import com.zyql.protobuf.runtime.AgentTaskStateNotification;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Le4/d;", "Le4/f;", "<init>", "()V", "Lcom/zyql/protobuf/connection/Head;", "head", "Lcom/google/protobuf/ByteString;", "bodyRaw", "Lcom/stepos/agentframework/adapter/bff/l;", "cacheBean", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/zyql/protobuf/connection/Head;Lcom/google/protobuf/ByteString;Lcom/stepos/agentframework/adapter/bff/l;)V", "Companion", "protocol_bff_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: e4.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3990d implements InterfaceC3992f {
    private static final String TAG = "BFF-ChatCommandHandlerV2";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: e4.d$b */
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentTaskStateNotification.State.values().length];
            try {
                iArr[AgentTaskStateNotification.State.STATE_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentTaskStateNotification.State.STATE_PROCESSING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentTaskStateNotification.State.STATE_COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentTaskStateNotification.State.STATE_INTERRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x06bd  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:216:? A[RETURN, SYNTHETIC] */
    @Override // e4.InterfaceC3992f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.zyql.protobuf.connection.Head r57, com.google.protobuf.ByteString r58, com.stepos.agentframework.adapter.bff.CacheBean r59) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instructions count: 1882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.C3990d.a(com.zyql.protobuf.connection.Head, com.google.protobuf.ByteString, com.stepos.agentframework.adapter.bff.l):void");
    }
}
