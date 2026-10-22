package com.stepos.ailauncher.task.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.task.R$id;
import com.stepos.ailauncher.task.R$layout;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/task/preview/d;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "width", "height", "Landroid/graphics/Bitmap;", Const.INTENT_KEY_APIKEY, "(II)Landroid/graphics/Bitmap;", "Landroid/content/Context;", "Companion", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final float ALL_TASKS_NUDGE_UP_PX = 2.0f;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/task/preview/d$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;)I", "", "ALL_TASKS_NUDGE_UP_PX", "F", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.preview.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final int a(Context context) {
            p.i(context, "context");
            int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", UxipConstants.f30662a);
            return identifier != 0 ? context.getResources().getDimensionPixelSize(identifier) : (int) (context.getResources().getDisplayMetrics().density * 48.0f);
        }

        public Companion() {
        }
    }

    public d(Context context) {
        p.i(context, "context");
        this.context = context;
    }

    public final Bitmap a(int width, int height) {
        if (width <= 0 || height <= 0) {
            return null;
        }
        View viewInflate = LayoutInflater.from(this.context).inflate(R$layout.view_amoo_editor_preview, (ViewGroup) null);
        int iA = INSTANCE.a(this.context);
        View viewFindViewById = viewInflate.findViewById(R$id.con_layout_input);
        p.h(viewFindViewById, "findViewById(...)");
        viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), iA);
        viewInflate.findViewById(R$id.btn_all_tasks).setTranslationY((-iA) - 2.0f);
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        viewInflate.layout(0, 0, width, height);
        a aVar = a.INSTANCE;
        View viewFindViewById2 = viewInflate.findViewById(R$id.tv_greeting);
        p.h(viewFindViewById2, "findViewById(...)");
        aVar.a((TextView) viewFindViewById2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        p.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        viewInflate.draw(canvas);
        return bitmapCreateBitmap;
    }
}
