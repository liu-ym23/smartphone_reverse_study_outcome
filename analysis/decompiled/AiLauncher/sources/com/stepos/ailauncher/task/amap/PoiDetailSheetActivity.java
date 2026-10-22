package com.stepos.ailauncher.task.amap;

import android.content.Context;
import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.fragment.app.Fragment;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.sheet.C2739j;
import com.stepos.ailauncher.sheet.S;
import com.stepos.ailauncher.sheet.SheetExitAnim;
import com.stepos.ailauncher.task.R$drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\f\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/task/amap/PoiDetailSheetActivity;", "Lcom/stepos/ailauncher/sheet/S;", "<init>", "()V", "Landroidx/fragment/app/Fragment;", "s4", "()Landroidx/fragment/app/Fragment;", "", "z4", "()Ljava/lang/String;", "f4", "", "Z3", "()Z", "Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "x1", "()Lcom/stepos/ailauncher/sheet/SheetExitAnim;", "i1", "", "T2", "()F", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "y4", "(Landroid/os/Bundle;)V", "Companion", Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PoiDetailSheetActivity extends S {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_DETAIL_JSON = "detail_json";
    private static final float PANEL_CORNER_DP = 20.0f;
    private static final String TAG_ROOT = "poi_detail_sheet";

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/task/amap/PoiDetailSheetActivity$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "detailJson", "LY8/t;", "c", "(Landroid/content/Context;Ljava/lang/String;)V", "Landroid/view/View;", "panel", "", "cornerDp", Const.INTENT_KEY_PKGNAME, "(Landroid/view/View;F)V", "TAG_ROOT", "Ljava/lang/String;", "EXTRA_DETAIL_JSON", "PANEL_CORNER_DP", "F", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.amap.PoiDetailSheetActivity$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/task/amap/PoiDetailSheetActivity$a$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.task.amap.PoiDetailSheetActivity$a$a, reason: collision with other inner class name */
        public static final class C0331a extends ViewOutlineProvider {
            final /* synthetic */ float $radiusPx;

            public C0331a(float f10) {
                this.$radiusPx = f10;
            }

            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view, Outline outline) {
                p.i(view, "view");
                p.i(outline, "outline");
                int width = view.getWidth();
                int height = view.getHeight();
                float f10 = this.$radiusPx;
                outline.setRoundRect(0, 0, width, height + ((int) f10), f10);
            }
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void b(View panel, float cornerDp) {
            float f10 = cornerDp * panel.getResources().getDisplayMetrics().density;
            panel.setClipToOutline(true);
            panel.setOutlineProvider(new C0331a(f10));
            panel.invalidateOutline();
        }

        public final void c(Context context, String detailJson) {
            p.i(context, "context");
            p.i(detailJson, "detailJson");
            Intent intentPutExtra = new Intent(context, (Class<?>) PoiDetailSheetActivity.class).putExtra(PoiDetailSheetActivity.EXTRA_DETAIL_JSON, detailJson);
            p.h(intentPutExtra, "putExtra(...)");
            C2739j.C(context, intentPutExtra, null, 4, null);
        }

        public Companion() {
        }
    }

    @Override // com.stepos.ailauncher.sheet.O
    public float T2() {
        return 20.0f;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean Z3() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public String f4() {
        String name = PoiDetailSheetActivity.class.getName();
        p.h(name, "getName(...)");
        return name;
    }

    @Override // com.stepos.ailauncher.sheet.O
    public boolean i1() {
        return false;
    }

    @Override // com.stepos.ailauncher.sheet.S
    public Fragment s4() {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(EXTRA_DETAIL_JSON) : null;
        if (stringExtra == null) {
            stringExtra = "";
        }
        return d.INSTANCE.a(stringExtra);
    }

    @Override // com.stepos.ailauncher.sheet.O
    public SheetExitAnim x1() {
        return SheetExitAnim.SLIDE_DOWN;
    }

    @Override // com.stepos.ailauncher.sheet.S
    public void y4(Bundle savedInstanceState) {
        M1().setPadding(0, 0, 0, 0);
        Y1().setBackgroundResource(R$drawable.bg_poi_detail_panel);
        INSTANCE.b(Y1(), 20.0f);
    }

    @Override // com.stepos.ailauncher.sheet.S
    public String z4() {
        return TAG_ROOT;
    }
}
