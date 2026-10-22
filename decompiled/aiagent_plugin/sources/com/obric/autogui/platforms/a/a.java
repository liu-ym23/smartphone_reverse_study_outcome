package com.obric.autogui.platforms.a;

import com.obric.aiagent.product.ObricProductSdk;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformInformation;
import com.obric.autogui.common.api.platform.AOPlatformInterface;
import com.obric.autogui.common.api.platform.AOPlatformToolsInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AbstractStandardPlatformInterface.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements AOPlatformInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AOPlatformToolsInterface f29948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0782a f29950d;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractStandardPlatformInterface.kt */
    public static final class C0782a implements AOPlatformInformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f29951a;

        C0782a(a r1) {
            this.f29951a = r1;
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public String getBrand() {
            return AOPlatformInformation.DefaultImpls.getBrand(this);
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public String getName() {
            return a.a(this.f29951a);
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public String getProject() {
            return ObricProductSdk.INSTANCE.featureService().getObricProductName();
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public int getFrameworkApiVersion() {
            return ObricProductSdk.INSTANCE.platformService().romInfo().getFwkApiVersion();
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public String getRomVersion() {
            return ObricProductSdk.INSTANCE.platformService().romInfo().getOSVersion();
        }

        public String toString() {
            return getName() + '[' + getProject() + "](f=" + getFrameworkApiVersion() + ", r=" + getRomVersion() + ')';
        }
    }

    public a(String r3, AOPlatformToolsInterface r4) {
        AOPlatformToolsInterface r5 = (AOPlatformToolsInterface) ZeusTransformUtils.wrapperContextForParams(r4, AOPlatformToolsInterface.class, "com.obric.aiagent.plugin");
        o.e(r3, "platformName");
        o.e(r5, "platformTools");
        this.f29947a = r3;
        this.f29948b = r5;
        this.f29949c = r3 + "Plat";
        this.f29950d = new C0782a(this);
    }

    public static final /* synthetic */ String a(a r0) {
        return r0.f29947a;
    }

    public String a() {
        return this.f29949c;
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformInterface
    public boolean init() {
        Loog.INSTANCE.d(a(), "[O-Auto] This is O-Auto on " + this.f29947a + '.');
        ObricProductSdk.INSTANCE.platformService().romInfo();
        return true;
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformInterface
    public AOPlatformInformation getInformation() {
        return (AOPlatformInformation) ZeusTransformUtils.preCheckCast(this.f29950d, AOPlatformInformation.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformInterface
    public AOPlatformToolsInterface getTools() {
        return this.f29948b;
    }
}
