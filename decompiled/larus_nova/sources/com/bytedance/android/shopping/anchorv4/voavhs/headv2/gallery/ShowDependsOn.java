package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/gallery/ShowDependsOn;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "GALLERY_FIND_SIMILAR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowDependsOn extends Enum<ShowDependsOn> {
    public static final a Companion = null;
    public static final ShowDependsOn GALLERY_FIND_SIMILAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowDependsOn[] f169269a = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    static {
        ShowDependsOn r100 = new ShowDependsOn();
        GALLERY_FIND_SIMILAR = r100;
        f169269a = new ShowDependsOn[]{r100};
        Companion = new a();
    }

    public static ShowDependsOn valueOf(String r100) {
        return (ShowDependsOn) r27.a.a(ShowDependsOn.class, r100);
    }

    public static ShowDependsOn[] values() {
        return (ShowDependsOn[]) f169269a.clone();
    }

    public ShowDependsOn() {
        super("GALLERY_FIND_SIMILAR", 0);
        this.value = "gallery_find_similar";
    }

    public final String getValue() {
        return this.value;
    }
}
