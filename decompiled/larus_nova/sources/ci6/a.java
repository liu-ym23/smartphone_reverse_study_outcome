package ci6;

import com.bytedance.live.layout.SDKAlign;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: ci6.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0449a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23856a = null;

        static {
            int[] r100 = new int[SDKAlign.values().length];
            r100[SDKAlign.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[SDKAlign.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[SDKAlign.END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f23856a = r100;
        }
    }

    public a() {
    }

    public static float a(float r100, float r101, SDKAlign r102, boolean r103) {
        int r104 = C0449a.f23856a[r102.ordinal()];
        if (r104 == 1) goto L15;
        if (r104 == 2) goto L21;
        if (r104 != 3) goto L13;
        if (r100 <= r101) goto L20;
        if (r103 == true) goto L21;
    L20:
        return r100 - r101;
    L13:
        throw new NoWhenBranchMatchedException();
    L21:
        return (r100 - r101) / 2;
    L15:
        if (r100 <= r101) goto L18;
        if (r103 == true) goto L21;
    L18:
        return 0.0f;
    }
}
