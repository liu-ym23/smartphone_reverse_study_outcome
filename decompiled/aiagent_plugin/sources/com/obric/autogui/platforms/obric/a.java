package com.obric.autogui.platforms.obric;

import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformInformation;
import com.obric.autogui.common.api.platform.AOPlatformInterface;
import com.obric.autogui.common.api.platform.AOPlatformToolsInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: ObricPlatformInterface.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements AOPlatformInterface {
    private static final String TAG = "ObricPlat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0788a f30050a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.platforms.obric.b f30051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IRomInfo f30052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f30053d;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.obric.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ObricPlatformInterface.kt */
    public static final class C0788a {
        public /* synthetic */ C0788a(h r1) {
            this();
        }

        private C0788a() {
        }
    }

    /* JADX INFO: compiled from: ObricPlatformInterface.kt */
    public static final class b implements AOPlatformInformation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f30055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f30056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f30057d;

        b() {
            this.f30054a = "Obric";
            this.f30055b = ObricProductSdk.INSTANCE.featureService().getObricProductName();
            this.f30056c = ObricProductSdk.INSTANCE.platformService().romInfo().getFwkApiVersion();
            this.f30057d = ObricProductSdk.INSTANCE.platformService().romInfo().getOSVersion();
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public String getBrand() {
            return AOPlatformInformation.DefaultImpls.getBrand(this);
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public String getName() {
            return this.f30054a;
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public String getProject() {
            return this.f30055b;
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public int getFrameworkApiVersion() {
            return this.f30056c;
        }

        @Override // com.obric.autogui.common.api.platform.AOPlatformInformation
        public String getRomVersion() {
            return this.f30057d;
        }

        public String toString() {
            return "Obric[" + getProject() + "](f=" + getFrameworkApiVersion() + ", r=" + getRomVersion() + ')';
        }
    }

    static {
        f30050a = new C0788a(null);
    }

    public a() {
        this.f30051b = new com.obric.autogui.platforms.obric.b();
        this.f30053d = new b();
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformInterface
    public boolean init() {
        Loog.INSTANCE.d(TAG, "[O-Auto] This is O-Auto on Obric.");
        this.f30052c = ObricProductSdk.INSTANCE.platformService().romInfo();
        return true;
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformInterface
    public AOPlatformInformation getInformation() {
        return (AOPlatformInformation) ZeusTransformUtils.preCheckCast(this.f30053d, AOPlatformInformation.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.autogui.common.api.platform.AOPlatformInterface
    public AOPlatformToolsInterface getTools() {
        return (AOPlatformToolsInterface) ZeusTransformUtils.preCheckCast(this.f30051b, AOPlatformToolsInterface.class, "com.obric.aiagent.plugin");
    }
}
