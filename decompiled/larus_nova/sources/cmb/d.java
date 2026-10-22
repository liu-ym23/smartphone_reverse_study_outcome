package cmb;

import com.bytedance.ee.bear.document.associated.QuickLaunchBarItemType;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f24249a = 0;

    public static final class a {

        /* JADX INFO: renamed from: cmb.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0461a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f24250a = null;

            static {
                int[] r100 = new int[QuickLaunchBarItemType.values().length];
                r100[QuickLaunchBarItemType.ADD_ASSOCIATION_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r100[QuickLaunchBarItemType.ASSOCIATED_DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r100[QuickLaunchBarItemType.ASSOCIATED_DOC_WITH_COLLABORATOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                f24250a = r100;
            }
        }
    }

    static {
    }
}
