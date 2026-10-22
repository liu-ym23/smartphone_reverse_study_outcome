package com.stepos.stepclaw.chroot;

import a6.f0;
import b5.a0;
import com.stepos.stepclaw.SecurePrefs;
import f5.c;
import h5.e;
import h5.i;
import kotlin.Metadata;
import p5.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<anonymous>", "(La6/f0;)Z"}, k = 3, mv = {2, 2, 0})
@e(c = "com.stepos.stepclaw.chroot.ChrootRootfsInitializer$initialize$2$1", f = "ChrootRootfsInitializer.kt", l = {257}, m = "invokeSuspend", v = 1)
/* loaded from: classes.dex */
public final class ChrootRootfsInitializer$initialize$2$1 extends i implements p {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ ChrootRootfsInitializer this$0;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HealthStatus.values().length];
            try {
                iArr[HealthStatus.FATAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HealthStatus.CRITICAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HealthStatus.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HealthStatus.OK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChrootRootfsInitializer$initialize$2$1(ChrootRootfsInitializer chrootRootfsInitializer, c cVar) {
        super(2, cVar);
        this.this$0 = chrootRootfsInitializer;
    }

    @Override // h5.a
    public final c create(Object obj, c cVar) {
        return new ChrootRootfsInitializer$initialize$2$1(this.this$0, cVar);
    }

    @Override // p5.p
    public final Object invoke(f0 f0Var, c cVar) {
        return ((ChrootRootfsInitializer$initialize$2$1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f4 A[Catch: Exception -> 0x01dd, TryCatch #1 {Exception -> 0x01dd, blocks: (B:42:0x014f, B:44:0x01cd, B:48:0x01d7, B:60:0x01f9, B:59:0x01f4, B:58:0x01ef, B:52:0x01e1, B:54:0x01e7, B:45:0x01d2), top: B:76:0x014f, inners: #0, #4 }] */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 822
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.chroot.ChrootRootfsInitializer$initialize$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
