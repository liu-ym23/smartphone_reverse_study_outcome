package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/ContainerName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BODY", "HEADER", "FOOTER", "CEILING", "GUIDE", "DIALOG", "TOP_STRAND", "HEADER_CEILING", "CONTAINER_HEADER_ADDRESS", "MASK", "POPUP", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ContainerName extends Enum<ContainerName> {
    public static final ContainerName BODY = null;
    public static final ContainerName CEILING = null;
    public static final ContainerName CONTAINER_HEADER_ADDRESS = null;
    public static final ContainerName DIALOG = null;
    public static final ContainerName FOOTER = null;
    public static final ContainerName GUIDE = null;
    public static final ContainerName HEADER = null;
    public static final ContainerName HEADER_CEILING = null;
    public static final ContainerName MASK = null;
    public static final ContainerName POPUP = null;
    public static final ContainerName TOP_STRAND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContainerName[] f164218a = null;
    private final String value;

    public static ContainerName valueOf(String r100) {
        return (ContainerName) a.a(ContainerName.class, r100);
    }

    public static ContainerName[] values() {
        return (ContainerName[]) f164218a.clone();
    }

    static {
        ContainerName r100 = new ContainerName("BODY", 0, ContainerPosition.BODY);
        BODY = r100;
        ContainerName r101 = new ContainerName("HEADER", 1, "header");
        HEADER = r101;
        ContainerName r102 = new ContainerName("FOOTER", 2, ContainerPosition.FOOTER);
        FOOTER = r102;
        ContainerName r103 = new ContainerName("CEILING", 3, "ceiling_container");
        CEILING = r103;
        ContainerName r104 = new ContainerName("GUIDE", 4, "guide");
        GUIDE = r104;
        ContainerName r105 = new ContainerName("DIALOG", 5, "dialog");
        DIALOG = r105;
        ContainerName r106 = new ContainerName("TOP_STRAND", 6, "top");
        TOP_STRAND = r106;
        ContainerName r107 = new ContainerName("HEADER_CEILING", 7, "header_ceiling");
        HEADER_CEILING = r107;
        ContainerName r108 = new ContainerName("CONTAINER_HEADER_ADDRESS", 8, "header_address");
        CONTAINER_HEADER_ADDRESS = r108;
        ContainerName r109 = new ContainerName("MASK", 9, BuyNowCloseMethod.MASK);
        MASK = r109;
        ContainerName r110 = new ContainerName("POPUP", 10, "popup");
        POPUP = r110;
        f164218a = new ContainerName[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getValue() {
        return this.value;
    }

    public ContainerName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
