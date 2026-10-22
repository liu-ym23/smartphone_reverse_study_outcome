package com.obric.autogui.resourcemanage;

import android.os.Build;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Year;

/* JADX INFO: compiled from: DefaultResourceRequestFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f30615c;

    /* JADX INFO: compiled from: DefaultResourceRequestFactory.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f30613a = new a(null);
    }

    public b(String r2, String r3) {
        d.h.b.o.e(r2, "sdkPkg");
        d.h.b.o.e(r3, "osDeviceId");
        this.f30614b = r2;
        this.f30615c = r3;
    }

    @Override // com.obric.autogui.resourcemanage.u
    public v a() {
        o r1 = d.f30616a.a(this.f30614b);
        String[] r2 = Build.SUPPORTED_ABIS;
        d.h.b.o.c(r2, "SUPPORTED_ABIS");
        String r3 = (String) ZeusTransformUtils.preCheckCast(d.a.i.c((Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.aiagent.plugin")), String.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        String r18 = SensitiveType.UNKNOWN;
    L6:
        boolean r6 = true;
        IRomInfo r4 = (IRomInfo) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IRomInfo.class, true), IRomInfo.class, "com.obric.aiagent.plugin");
        Map<String, String> r13 = c.a(String.valueOf(IAppContext.Companion.getVersionCode()), String.valueOf(IAppContext.Companion.getUpdateVersionCode()), String.valueOf(r4.getOSReleaseDate()), String.valueOf(r4.getFwkApiVersion()), r4.getShortOSVersion().toString(), this.f30615c, String.valueOf(r4.isUTRom()));
        String r0 = this.f30614b;
        if (r1 == null) goto L9;
        int r7 = r1.e();
    L11:
        if (r1 == null) goto L22;
        String r5 = r1.f();
        if (r5 == null) goto L22;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() > 0) goto L18;
        r6 = false;
    L18:
        if (r6 == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L22;
    L23:
        String r9 = r5;
        List r12 = d.a.p.b();
        String r8 = Build.BRAND;
        if (r8 != null) goto L26;
        String r16 = SensitiveType.UNKNOWN;
    L27:
        String r10 = Build.MODEL;
        if (r10 != null) goto L30;
        String r17 = SensitiveType.UNKNOWN;
    L32:
        return new v(r0, r7, 1, r9, 1, Year.MAX_VALUE, r12, r13, 36, "com.larus.nova", r16, r17, r18);
    L30:
        r17 = r10;
        goto L32
    L26:
        r16 = r8;
    L22:
        r5 = "0";
        goto L23
    L9:
        r7 = 0;
        goto L11
    L5:
        r18 = r3;
        goto L6
    }
}
