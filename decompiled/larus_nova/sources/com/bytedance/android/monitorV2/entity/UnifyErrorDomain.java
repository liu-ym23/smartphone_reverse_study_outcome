package com.bytedance.android.monitorV2.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/UnifyErrorDomain;", "", "", "errorDomain", "I", "getErrorDomain", "()I", "AnnieXUnifyErrorDomainReserved", "AnnieXUnifyErrorDomainContainerInit", "AnnieXUnifyErrorDomainContainerPlugin", "AnnieXUnifyErrorDomainContainerJSB", "AnnieXUnifyErrorDomainEngineWeb", "AnnieXUnifyErrorDomainEngineLynx", "AnnieXUnifyErrorDomainResourceLoader", "AnnieXUnifyErrorDomainFetch", "AnnieXUnifyErrorDomainStaticResource", "AnnieXUnifyErrorDomainJS", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum UnifyErrorDomain extends Enum<UnifyErrorDomain> {
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainContainerInit = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainContainerJSB = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainContainerPlugin = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainEngineLynx = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainEngineWeb = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainFetch = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainJS = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainReserved = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainResourceLoader = null;
    public static final UnifyErrorDomain AnnieXUnifyErrorDomainStaticResource = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UnifyErrorDomain[] f163000a = null;
    private final int errorDomain;

    public static UnifyErrorDomain valueOf(String r100) {
        return (UnifyErrorDomain) a.a(UnifyErrorDomain.class, r100);
    }

    public static UnifyErrorDomain[] values() {
        return (UnifyErrorDomain[]) f163000a.clone();
    }

    static {
        UnifyErrorDomain r100 = new UnifyErrorDomain("AnnieXUnifyErrorDomainReserved", 0, 99999999);
        AnnieXUnifyErrorDomainReserved = r100;
        UnifyErrorDomain r101 = new UnifyErrorDomain("AnnieXUnifyErrorDomainContainerInit", 1, 33000000);
        AnnieXUnifyErrorDomainContainerInit = r101;
        UnifyErrorDomain r102 = new UnifyErrorDomain("AnnieXUnifyErrorDomainContainerPlugin", 2, 35000000);
        AnnieXUnifyErrorDomainContainerPlugin = r102;
        UnifyErrorDomain r103 = new UnifyErrorDomain("AnnieXUnifyErrorDomainContainerJSB", 3, 37000000);
        AnnieXUnifyErrorDomainContainerJSB = r103;
        UnifyErrorDomain r104 = new UnifyErrorDomain("AnnieXUnifyErrorDomainEngineWeb", 4, 47000000);
        AnnieXUnifyErrorDomainEngineWeb = r104;
        UnifyErrorDomain r105 = new UnifyErrorDomain("AnnieXUnifyErrorDomainEngineLynx", 5, 50000000);
        AnnieXUnifyErrorDomainEngineLynx = r105;
        UnifyErrorDomain r110 = new UnifyErrorDomain("AnnieXUnifyErrorDomainResourceLoader", 6, 63000000);
        AnnieXUnifyErrorDomainResourceLoader = r110;
        UnifyErrorDomain r111 = new UnifyErrorDomain("AnnieXUnifyErrorDomainFetch", 7, 65000000);
        AnnieXUnifyErrorDomainFetch = r111;
        UnifyErrorDomain r112 = new UnifyErrorDomain("AnnieXUnifyErrorDomainStaticResource", 8, 67000000);
        AnnieXUnifyErrorDomainStaticResource = r112;
        UnifyErrorDomain r113 = new UnifyErrorDomain("AnnieXUnifyErrorDomainJS", 9, 70000000);
        AnnieXUnifyErrorDomainJS = r113;
        f163000a = new UnifyErrorDomain[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public final int getErrorDomain() {
        return this.errorDomain;
    }

    public UnifyErrorDomain(String r100, int r101, int r102) {
        super(r100, r101);
        this.errorDomain = r102;
    }
}
