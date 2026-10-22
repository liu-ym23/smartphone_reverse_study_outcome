package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.compose.ui.text.TextRange;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import f06.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import p016j.a;
import p016j.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020!H\u0002J\u0016\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014J\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\u0006J\u0014\u0010%\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0014\u0010%\u001a\u00020\u0014*\u00020&2\u0006\u0010\t\u001a\u00020\u0006H\u0002RE\u0010\u0004\u001a#\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0093\u0001\u0010\u0011\u001aq\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Landroidx/compose/foundation/text/contextmenu/ProcessTextApi23Impl;", "", "<init>", "()V", "processTextActivitiesQuery", "Lkotlin/Function1;", "Landroid/content/Context;", "Lkotlin/ParameterName;", "name", PerfLog.PARAM_KEY_CONTEXT_ID, "", "Landroid/content/pm/ResolveInfo;", "getProcessTextActivitiesQuery$annotations", "getProcessTextActivitiesQuery", "()Lkotlin/jvm/functions/Function1;", "setProcessTextActivitiesQuery", "(Lkotlin/jvm/functions/Function1;)V", "onClickProcessTextItem", "Lkotlin/Function5;", "resolveInfo", "", "editable", "", "text", "Landroidx/compose/ui/text/TextRange;", "textRange", "", "getOnClickProcessTextItem$annotations", "getOnClickProcessTextItem", "()Lkotlin/jvm/functions/Function5;", "setOnClickProcessTextItem", "(Lkotlin/jvm/functions/Function5;)V", "createProcessTextIntent", "Landroid/content/Intent;", "createProcessTextIntentForResolveInfo", "info", "queryProcessTextActivities", "hasPermission", "Landroid/content/pm/ActivityInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProcessTextApi23Impl {
    public static final int $stable = 0;
    public static final ProcessTextApi23Impl INSTANCE = null;
    private static Function5<? super Context, ? super ResolveInfo, ? super Boolean, ? super CharSequence, ? super TextRange, Unit> onClickProcessTextItem;
    private static Function1<? super Context, ? extends List<? extends ResolveInfo>> processTextActivitiesQuery;

    private ProcessTextApi23Impl() {
    }

    public static /* synthetic */ Unit a(Context r100, ResolveInfo r101, boolean r102, CharSequence r103, TextRange r104) {
        return onClickProcessTextItem$lambda$2(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ List b(Context r100) {
        return processTextActivitiesQuery$lambda$1(r100);
    }

    public static /* synthetic */ void getOnClickProcessTextItem$annotations() {
    }

    public static /* synthetic */ void getProcessTextActivitiesQuery$annotations() {
    }

    static {
        INSTANCE = new ProcessTextApi23Impl();
        processTextActivitiesQuery = new a();
        onClickProcessTextItem = new b();
        $stable = 8;
    }

    private final Intent createProcessTextIntent() {
        return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }

    public final Function5<Context, ResolveInfo, Boolean, CharSequence, TextRange, Unit> getOnClickProcessTextItem() {
        return onClickProcessTextItem;
    }

    public final Function1<Context, List<ResolveInfo>> getProcessTextActivitiesQuery() {
        return processTextActivitiesQuery;
    }

    private static final List processTextActivitiesQuery$lambda$1(Context r100) {
        int r101 = 0;
        List<ResolveInfo> r102 = r100.getPackageManager().queryIntentActivities(INSTANCE.createProcessTextIntent(), 0);
        ArrayList r103 = new ArrayList(r102.size());
        int r104 = r102.size();
    L3:
        if (r101 >= r104) goto L8;
        Object r105 = ListProtector.get(r102, r101);
        ProcessTextApi23Impl r106 = INSTANCE;
        if (r106.hasPermission((ResolveInfo) r105, r100) == false) goto L7;
        r103.add(r105);
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        return r103;
    }

    public final List<ResolveInfo> queryProcessTextActivities(Context r100) {
        return (List) processTextActivitiesQuery.invoke(r100);
    }

    public final void setOnClickProcessTextItem(Function5<? super Context, ? super ResolveInfo, ? super Boolean, ? super CharSequence, ? super TextRange, Unit> r100) {
        onClickProcessTextItem = r100;
    }

    public final void setProcessTextActivitiesQuery(Function1<? super Context, ? extends List<? extends ResolveInfo>> r100) {
        processTextActivitiesQuery = r100;
    }

    private static int androidx_compose_foundation_text_contextmenu_ProcessTextApi23Impl_android_content_Context_checkSelfPermission(Context r110, String r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b("auto_cert_androidx_compose_foundation_text_contextmenu_ProcessTextApi23Impl_android_content_Context_checkSelfPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102608);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkSelfPermission(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private final boolean hasPermission(ResolveInfo r100, Context r101) {
        if (r101.getPackageName().equals(r100.activityInfo.packageName) == false) goto L5;
    L8:
        return true;
    L5:
        if (hasPermission(r100.activityInfo, r101) == true) goto L8;
        return false;
    }

    public final Intent createProcessTextIntentForResolveInfo(ResolveInfo r100, boolean r101) {
        Intent r102 = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", r101);
        ActivityInfo r103 = r100.activityInfo;
        return r102.setClassName(r103.packageName, r103.name);
    }

    private final boolean hasPermission(ActivityInfo r100, Context r101) {
        if (r100.exported == false) goto L9;
        String r102 = r100.permission;
        if (r102 != null) goto L7;
    L8:
        return true;
    L7:
        if (androidx_compose_foundation_text_contextmenu_ProcessTextApi23Impl_android_content_Context_checkSelfPermission(r101, r102) == 0) goto L8;
    L9:
        return false;
    }

    private static final Unit onClickProcessTextItem$lambda$2(Context r100, ResolveInfo r101, boolean r102, CharSequence r103, TextRange r104) {
        String r105 = r103.subSequence(TextRange.m6996getMinimpl(r104.m7002unboximpl()), TextRange.m6995getMaximpl(r104.m7002unboximpl())).toString();
        Intent r106 = INSTANCE.createProcessTextIntentForResolveInfo(r101, r102);
        r106.putExtra("android.intent.extra.PROCESS_TEXT", r105);
        r100.startActivity(r106);
        return Unit.INSTANCE;
    }
}
