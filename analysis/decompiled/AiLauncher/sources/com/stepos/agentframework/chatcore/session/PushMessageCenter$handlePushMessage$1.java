package com.stepos.agentframework.chatcore.session;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.C0917m;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import u4.AgentResponse;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.session.PushMessageCenter$handlePushMessage$1", f = "PushMessageCenter.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: classes2.dex */
public final class PushMessageCenter$handlePushMessage$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ C0917m $chatReplyInfo;
    final /* synthetic */ boolean $disconnectFinalize;
    final /* synthetic */ AgentResponse $response;
    final /* synthetic */ AgentRole $role;
    private /* synthetic */ Object L$0;
    int label;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EReplyStatus.values().length];
            try {
                iArr[EReplyStatus.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EReplyStatus.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EReplyStatus.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushMessageCenter$handlePushMessage$1(AgentResponse agentResponse, C0917m c0917m, boolean z10, AgentRole agentRole, InterfaceC4014c<? super PushMessageCenter$handlePushMessage$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$response = agentResponse;
        this.$chatReplyInfo = c0917m;
        this.$disconnectFinalize = z10;
        this.$role = agentRole;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        PushMessageCenter$handlePushMessage$1 pushMessageCenter$handlePushMessage$1 = new PushMessageCenter$handlePushMessage$1(this.$response, this.$chatReplyInfo, this.$disconnectFinalize, this.$role, interfaceC4014c);
        pushMessageCenter$handlePushMessage$1.L$0 = obj;
        return pushMessageCenter$handlePushMessage$1;
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((PushMessageCenter$handlePushMessage$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0508 A[Catch: all -> 0x06b8, TryCatch #0 {all -> 0x06b8, blocks: (B:5:0x001a, B:8:0x0029, B:215:0x06b1, B:10:0x0032, B:11:0x0037, B:13:0x0044, B:14:0x005c, B:19:0x0068, B:22:0x0083, B:24:0x0089, B:25:0x009f, B:28:0x00d9, B:32:0x014a, B:34:0x0150, B:36:0x0174, B:40:0x0180, B:42:0x0186, B:44:0x01b6, B:45:0x01ba, B:38:0x017a, B:29:0x011a, B:31:0x0120, B:46:0x01bf, B:48:0x01cb, B:51:0x01d7, B:54:0x01de, B:57:0x01e5, B:60:0x01ec, B:62:0x01f6, B:63:0x020e, B:65:0x023f, B:67:0x0245, B:68:0x0263, B:70:0x026f, B:75:0x027f, B:78:0x0286, B:80:0x0290, B:81:0x02b5, B:82:0x02e7, B:83:0x0305, B:85:0x0311, B:88:0x0319, B:91:0x0321, B:94:0x0329, B:98:0x0333, B:100:0x0339, B:103:0x0340, B:105:0x034a, B:106:0x0368, B:108:0x0370, B:109:0x038e, B:110:0x03b6, B:111:0x03e0, B:116:0x03f5, B:114:0x03ef, B:117:0x0413, B:119:0x0419, B:121:0x0421, B:123:0x0429, B:125:0x0431, B:126:0x045b, B:128:0x0463, B:131:0x0469, B:134:0x0474, B:136:0x0486, B:138:0x0492, B:140:0x0498, B:142:0x049e, B:157:0x04cc, B:160:0x04ea, B:162:0x0508, B:163:0x050c, B:179:0x0543, B:181:0x054d, B:183:0x0555, B:185:0x0568, B:187:0x0572, B:189:0x0578, B:191:0x057d, B:192:0x0582, B:194:0x0594, B:196:0x05bf, B:214:0x067a, B:197:0x05cd, B:201:0x05ed, B:204:0x0639, B:206:0x0662, B:209:0x0668, B:211:0x066e, B:213:0x0675, B:166:0x0514, B:168:0x0522, B:147:0x04aa, B:149:0x04b6, B:151:0x04bc, B:153:0x04c2), top: B:226:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0514 A[Catch: all -> 0x06b8, TryCatch #0 {all -> 0x06b8, blocks: (B:5:0x001a, B:8:0x0029, B:215:0x06b1, B:10:0x0032, B:11:0x0037, B:13:0x0044, B:14:0x005c, B:19:0x0068, B:22:0x0083, B:24:0x0089, B:25:0x009f, B:28:0x00d9, B:32:0x014a, B:34:0x0150, B:36:0x0174, B:40:0x0180, B:42:0x0186, B:44:0x01b6, B:45:0x01ba, B:38:0x017a, B:29:0x011a, B:31:0x0120, B:46:0x01bf, B:48:0x01cb, B:51:0x01d7, B:54:0x01de, B:57:0x01e5, B:60:0x01ec, B:62:0x01f6, B:63:0x020e, B:65:0x023f, B:67:0x0245, B:68:0x0263, B:70:0x026f, B:75:0x027f, B:78:0x0286, B:80:0x0290, B:81:0x02b5, B:82:0x02e7, B:83:0x0305, B:85:0x0311, B:88:0x0319, B:91:0x0321, B:94:0x0329, B:98:0x0333, B:100:0x0339, B:103:0x0340, B:105:0x034a, B:106:0x0368, B:108:0x0370, B:109:0x038e, B:110:0x03b6, B:111:0x03e0, B:116:0x03f5, B:114:0x03ef, B:117:0x0413, B:119:0x0419, B:121:0x0421, B:123:0x0429, B:125:0x0431, B:126:0x045b, B:128:0x0463, B:131:0x0469, B:134:0x0474, B:136:0x0486, B:138:0x0492, B:140:0x0498, B:142:0x049e, B:157:0x04cc, B:160:0x04ea, B:162:0x0508, B:163:0x050c, B:179:0x0543, B:181:0x054d, B:183:0x0555, B:185:0x0568, B:187:0x0572, B:189:0x0578, B:191:0x057d, B:192:0x0582, B:194:0x0594, B:196:0x05bf, B:214:0x067a, B:197:0x05cd, B:201:0x05ed, B:204:0x0639, B:206:0x0662, B:209:0x0668, B:211:0x066e, B:213:0x0675, B:166:0x0514, B:168:0x0522, B:147:0x04aa, B:149:0x04b6, B:151:0x04bc, B:153:0x04c2), top: B:226:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0572 A[Catch: all -> 0x06b8, TryCatch #0 {all -> 0x06b8, blocks: (B:5:0x001a, B:8:0x0029, B:215:0x06b1, B:10:0x0032, B:11:0x0037, B:13:0x0044, B:14:0x005c, B:19:0x0068, B:22:0x0083, B:24:0x0089, B:25:0x009f, B:28:0x00d9, B:32:0x014a, B:34:0x0150, B:36:0x0174, B:40:0x0180, B:42:0x0186, B:44:0x01b6, B:45:0x01ba, B:38:0x017a, B:29:0x011a, B:31:0x0120, B:46:0x01bf, B:48:0x01cb, B:51:0x01d7, B:54:0x01de, B:57:0x01e5, B:60:0x01ec, B:62:0x01f6, B:63:0x020e, B:65:0x023f, B:67:0x0245, B:68:0x0263, B:70:0x026f, B:75:0x027f, B:78:0x0286, B:80:0x0290, B:81:0x02b5, B:82:0x02e7, B:83:0x0305, B:85:0x0311, B:88:0x0319, B:91:0x0321, B:94:0x0329, B:98:0x0333, B:100:0x0339, B:103:0x0340, B:105:0x034a, B:106:0x0368, B:108:0x0370, B:109:0x038e, B:110:0x03b6, B:111:0x03e0, B:116:0x03f5, B:114:0x03ef, B:117:0x0413, B:119:0x0419, B:121:0x0421, B:123:0x0429, B:125:0x0431, B:126:0x045b, B:128:0x0463, B:131:0x0469, B:134:0x0474, B:136:0x0486, B:138:0x0492, B:140:0x0498, B:142:0x049e, B:157:0x04cc, B:160:0x04ea, B:162:0x0508, B:163:0x050c, B:179:0x0543, B:181:0x054d, B:183:0x0555, B:185:0x0568, B:187:0x0572, B:189:0x0578, B:191:0x057d, B:192:0x0582, B:194:0x0594, B:196:0x05bf, B:214:0x067a, B:197:0x05cd, B:201:0x05ed, B:204:0x0639, B:206:0x0662, B:209:0x0668, B:211:0x066e, B:213:0x0675, B:166:0x0514, B:168:0x0522, B:147:0x04aa, B:149:0x04b6, B:151:0x04bc, B:153:0x04c2), top: B:226:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05cd A[Catch: all -> 0x06b8, TryCatch #0 {all -> 0x06b8, blocks: (B:5:0x001a, B:8:0x0029, B:215:0x06b1, B:10:0x0032, B:11:0x0037, B:13:0x0044, B:14:0x005c, B:19:0x0068, B:22:0x0083, B:24:0x0089, B:25:0x009f, B:28:0x00d9, B:32:0x014a, B:34:0x0150, B:36:0x0174, B:40:0x0180, B:42:0x0186, B:44:0x01b6, B:45:0x01ba, B:38:0x017a, B:29:0x011a, B:31:0x0120, B:46:0x01bf, B:48:0x01cb, B:51:0x01d7, B:54:0x01de, B:57:0x01e5, B:60:0x01ec, B:62:0x01f6, B:63:0x020e, B:65:0x023f, B:67:0x0245, B:68:0x0263, B:70:0x026f, B:75:0x027f, B:78:0x0286, B:80:0x0290, B:81:0x02b5, B:82:0x02e7, B:83:0x0305, B:85:0x0311, B:88:0x0319, B:91:0x0321, B:94:0x0329, B:98:0x0333, B:100:0x0339, B:103:0x0340, B:105:0x034a, B:106:0x0368, B:108:0x0370, B:109:0x038e, B:110:0x03b6, B:111:0x03e0, B:116:0x03f5, B:114:0x03ef, B:117:0x0413, B:119:0x0419, B:121:0x0421, B:123:0x0429, B:125:0x0431, B:126:0x045b, B:128:0x0463, B:131:0x0469, B:134:0x0474, B:136:0x0486, B:138:0x0492, B:140:0x0498, B:142:0x049e, B:157:0x04cc, B:160:0x04ea, B:162:0x0508, B:163:0x050c, B:179:0x0543, B:181:0x054d, B:183:0x0555, B:185:0x0568, B:187:0x0572, B:189:0x0578, B:191:0x057d, B:192:0x0582, B:194:0x0594, B:196:0x05bf, B:214:0x067a, B:197:0x05cd, B:201:0x05ed, B:204:0x0639, B:206:0x0662, B:209:0x0668, B:211:0x066e, B:213:0x0675, B:166:0x0514, B:168:0x0522, B:147:0x04aa, B:149:0x04b6, B:151:0x04bc, B:153:0x04c2), top: B:226:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06c9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r40) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatcore.session.PushMessageCenter$handlePushMessage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
