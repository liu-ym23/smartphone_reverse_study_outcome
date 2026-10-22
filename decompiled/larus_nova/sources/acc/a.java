package acc;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.cleanresource.ResourceType;
import com.ss.android.lark.widget.mark.MarkView;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f2912a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f2913b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f2914c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Boolean> f2915d = null;

    /* JADX INFO: renamed from: acc.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0053a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2916a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[ResourceType.STICKER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[ResourceType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ResourceType.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f2916a = r100;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f2917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f2918b;

        public b(Context r100, String r101) {
            this.f2917a = r100;
            this.f2918b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            UDToast.show(this.f2917a, this.f2918b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f2912a = UIHelper.dp2px(52.0f);
        f2913b = UIHelper.dp2px(40.0f);
        f2914c = UIHelper.dp2px(7.0f);
        f2915d = new HashMap();
    }

    @JvmStatic
    public static final boolean d(String r100) {
        if (r100 != null) goto L6;
        return true;
    L6:
        return Intrinsics.areEqual(xbc.a.a().getCurrentTenantId(), r100);
    }

    @JvmStatic
    public static final boolean a(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100 == false) goto L6;
        f2915d.put(r101, Boolean.TRUE);
        return true;
    L6:
        return f2915d.containsKey(r101);
    }

    @JvmStatic
    public static final String b(Context r110, d r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "params");
        ResourceCleanScene r100 = r111.f2928b;
        ResourceType r101 = r111.getType();
        if (r100 != null) goto L28;
        if (r111.f2929c == false) goto L16;
        int r102 = C0053a.f2916a[r101.ordinal()];
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L15;
        if (r102 == 3) goto L14;
        if (r102 != 4) goto L13;
        String r103 = UIUtils.getString(r110, R.string.Lark_IM_FileCleanedByAdmin_Toast);
    L26:
        Intrinsics.checkNotNull(r103);
        return r103;
    L13:
        throw new NoWhenBranchMatchedException();
    L14:
        r103 = UIUtils.getString(r110, R.string.Lark_IM_VideoCleanedByAdmin_Toast);
    L15:
        r103 = UIUtils.getString(r110, R.string.Lark_IM_ImageCleanedByAdmin_Toast);
        goto L26
    L16:
        int r104 = C0053a.f2916a[r101.ordinal()];
        if (r104 == 1) goto L25;
        if (r104 == 2) goto L25;
        if (r104 == 3) goto L24;
        if (r104 != 4) goto L23;
        r103 = UIUtils.getString(r110, R.string.Lark_IM_FileCleanedByOtherAdminCantView_Toast);
        goto L26
    L23:
        throw new NoWhenBranchMatchedException();
    L24:
        r103 = UIUtils.getString(r110, R.string.Lark_IM_VideoCleanedByOtherAdminCantView_Toast);
    L25:
        r103 = UIUtils.getString(r110, R.string.Lark_IM_ImageCleanedByOtherAdminCantView_Toast);
        goto L26
    L28:
        if (r100.isUnifiedRegularDelete() == false) goto L65;
        if (r100.isPersonalDelete() == false) goto L42;
        int r105 = C0053a.f2916a[r101.ordinal()];
        if (r105 == 1) goto L40;
        if (r105 == 2) goto L40;
        if (r105 == 3) goto L39;
        if (r105 != 4) goto L38;
        String r106 = UIUtils.getString(r110, R.string.Lark_IM_FileCleanedCantView_Toast);
    L63:
        Intrinsics.checkNotNull(r106);
        return r106;
    L38:
        throw new NoWhenBranchMatchedException();
    L39:
        r106 = UIUtils.getString(r110, R.string.Lark_IM_VideoCleanedCantView_Toast);
    L40:
        r106 = UIUtils.getString(r110, R.string.Lark_IM_ImageCleanedCantView_Toast);
        goto L63
    L42:
        if (r111.f2929c == false) goto L53;
        int r107 = C0053a.f2916a[r101.ordinal()];
        if (r107 == 1) goto L52;
        if (r107 == 2) goto L52;
        if (r107 == 3) goto L51;
        if (r107 != 4) goto L50;
        r106 = UIUtils.getString(r110, R.string.Lark_IM_FileCleanedByAdmin_Toast);
        goto L63
    L50:
        throw new NoWhenBranchMatchedException();
    L51:
        r106 = UIUtils.getString(r110, R.string.Lark_IM_VideoCleanedByAdmin_Toast);
    L52:
        r106 = UIUtils.getString(r110, R.string.Lark_IM_ImageCleanedByAdmin_Toast);
        goto L63
    L53:
        int r108 = C0053a.f2916a[r101.ordinal()];
        if (r108 == 1) goto L62;
        if (r108 == 2) goto L62;
        if (r108 == 3) goto L61;
        if (r108 != 4) goto L60;
        r106 = UIUtils.getString(r110, R.string.Lark_IM_FileCleanedByOtherAdminCantView_Toast);
        goto L63
    L60:
        throw new NoWhenBranchMatchedException();
    L61:
        r106 = UIUtils.getString(r110, R.string.Lark_IM_VideoCleanedByOtherAdminCantView_Toast);
    L62:
        r106 = UIUtils.getString(r110, R.string.Lark_IM_ImageCleanedByOtherAdminCantView_Toast);
        goto L63
    L65:
        if (r100.isCSAMDelete() == true) goto L81;
        int r109 = C0053a.f2916a[r101.ordinal()];
        if (r109 == 1) goto L76;
        if (r109 == 2) goto L76;
        if (r109 == 3) goto L75;
        if (r109 != 4) goto L74;
        String r112 = UIUtils.getString(r110, R.string.Lark_IM_FileCleanedCantView_Toast);
    L77:
        Intrinsics.checkNotNull(r112);
        return r112;
    L74:
        throw new NoWhenBranchMatchedException();
    L75:
        r112 = UIUtils.getString(r110, R.string.Lark_IM_VideoCleanedCantView_Toast);
    L76:
        r112 = UIUtils.getString(r110, R.string.Lark_IM_ImageCleanedCantView_Toast);
        goto L77
    L81:
        return UIUtils.getString(r110, R.string.Lark_IM_FileRemovedByPolicy_Toast);
    }

    @JvmStatic
    public static final void f(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        UICallbackExecutor.execute(new b(r100, b(r100, r101)));
    }

    @JvmStatic
    public static final boolean c(int r100, int r101, float r102) {
        Log.i("ResourceCleanUIUtils", "imageWidth = " + r100 + ", imageHeight = " + r101 + ", markViewWidth = " + r102 + '.');
        if (r100 != (-1)) goto L6;
        if (r101 != (-1)) goto L6;
        return true;
    L6:
        float r103 = r100;
        int r104 = f2912a;
        if (r103 >= r104) goto L9;
    L17:
        return false;
    L9:
        if (r101 < f2913b) goto L17;
        float r105 = r102 + (f2914c * 2);
        if (r105 >= r104) goto L13;
    L15:
        return false;
    L13:
        if (r105 > r103) goto L15;
        Log.i("ResourceCleanUIUtils", "imageMinWidth = " + r104 + ", realWidth = " + r105 + ", imageWidth = " + r100);
        return true;
    }

    @JvmStatic
    public static final void e(Context r100, int r101, int r102, MarkView r110, MarkView r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "cleanedTipView");
        r110.setText(UIUtils.getString(r100, R.string.Lark_IM_FileExpiredByAdmin_Label));
        r110.post(new acc.b(r101, r102, r110, r111, r100));
    }
}
