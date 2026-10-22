package com.stepos.ailauncher.task.debug;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import Z8.C1173v;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.task.R$string;
import com.stepos.ailauncher.taskstore.widget.TaskInfoCardMediumView;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.List;
import kotlin.Metadata;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u0001:\u0002<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020!H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020&2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020!H\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020&2\u0006\u0010%\u001a\u00020!H\u0002¢\u0006\u0004\b-\u0010(J\u000f\u0010/\u001a\u00020.H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\bH\u0002¢\u0006\u0004\b1\u0010\rJ\u000f\u00103\u001a\u000202H\u0002¢\u0006\u0004\b3\u00104R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/stepos/ailauncher/task/debug/SweepTextScenarioPreviewActivity;", "Lz5/a;", "<init>", "()V", "Landroid/view/View;", "x", "()Landroid/view/View;", "y", "", UxipConstants.f30680s, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(I)I", "L", "()I", "Landroid/os/Bundle;", "savedInstanceState", "LY8/t;", "onCreate", "(Landroid/os/Bundle;)V", "onDestroy", "K", "G", "", "error", "F", "(Ljava/lang/Throwable;)V", "written", "H", "(I)V", "", "Lcom/stepos/ailauncher/task/debug/SweepTextScenarioPreviewActivity$b;", ExifInterface.LONGITUDE_EAST, "()Ljava/util/List;", "", "taskId", "C", "(Ljava/lang/String;)Landroid/view/View;", "text", "Landroid/widget/TextView;", "J", "(Ljava/lang/String;)Landroid/widget/TextView;", "title", "note", "v", "(Ljava/lang/String;Ljava/lang/String;)Landroid/widget/TextView;", "B", "Landroid/graphics/drawable/GradientDrawable;", "I", "()Landroid/graphics/drawable/GradientDrawable;", "D", "Landroid/widget/LinearLayout$LayoutParams;", "w", "()Landroid/widget/LinearLayout$LayoutParams;", "LUa/M;", "scope", "LUa/M;", "Landroid/widget/LinearLayout;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Landroid/widget/LinearLayout;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SweepTextScenarioPreviewActivity extends ActivityC6361a {
    private static final a Companion = new a(null);
    private static final int FIGMA_MEDIUM_CARD_WIDTH_DP = 352;
    private LinearLayout content;
    private final M scope = kotlinx.coroutines.d.a(L0.b(null, 1, null).plus(Y.c().getImmediate()));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/task/debug/SweepTextScenarioPreviewActivity$a;", "", "<init>", "()V", "", "FIGMA_MEDIUM_CARD_WIDTH_DP", "I", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/task/debug/SweepTextScenarioPreviewActivity$b;", "", "", "title", "note", "taskId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.debug.SweepTextScenarioPreviewActivity$b, reason: from toString */
    public static final /* data */ class MediumPreviewCase {
        private final String note;
        private final String taskId;
        private final String title;

        public MediumPreviewCase(String title, String note, String taskId) {
            kotlin.jvm.internal.p.i(title, "title");
            kotlin.jvm.internal.p.i(note, "note");
            kotlin.jvm.internal.p.i(taskId, "taskId");
            this.title = title;
            this.note = note;
            this.taskId = taskId;
        }

        /* renamed from: a, reason: from getter */
        public final String getNote() {
            return this.note;
        }

        /* renamed from: b, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: c, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediumPreviewCase)) {
                return false;
            }
            MediumPreviewCase mediumPreviewCase = (MediumPreviewCase) other;
            return kotlin.jvm.internal.p.d(this.title, mediumPreviewCase.title) && kotlin.jvm.internal.p.d(this.note, mediumPreviewCase.note) && kotlin.jvm.internal.p.d(this.taskId, mediumPreviewCase.taskId);
        }

        public int hashCode() {
            return (((this.title.hashCode() * 31) + this.note.hashCode()) * 31) + this.taskId.hashCode();
        }

        public String toString() {
            return "MediumPreviewCase(title=" + this.title + ", note=" + this.note + ", taskId=" + this.taskId + ")";
        }
    }

    private final int A(int value) {
        return (int) (value * getResources().getDisplayMetrics().density);
    }

    private final int L() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", UxipConstants.f30662a);
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final View x() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(Color.parseColor("#050507"));
        linearLayout.addView(y());
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(0, A(18), 0, A(28));
        this.content = linearLayout2;
        ScrollView scrollView = new ScrollView(this);
        LinearLayout linearLayout3 = this.content;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            linearLayout3 = null;
        }
        scrollView.addView(linearLayout3);
        linearLayout.addView(scrollView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return linearLayout;
    }

    private final View y() {
        int iL = L();
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(A(12), iL, A(16), 0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, A(58) + iL));
        TextView textView = new TextView(linearLayout.getContext());
        textView.setText("‹");
        textView.setTextSize(34.0f);
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.task.debug.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SweepTextScenarioPreviewActivity.z(this.f28422a, view);
            }
        });
        linearLayout.addView(textView, new LinearLayout.LayoutParams(A(42), -1));
        TextView textView2 = new TextView(linearLayout.getContext());
        textView2.setText(getString(R$string.task_sweep_scenario_preview_title));
        textView2.setTextSize(18.0f);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setTextColor(-1);
        textView2.setGravity(16);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(0, -1, 1.0f));
        return linearLayout;
    }

    public static final void z(SweepTextScenarioPreviewActivity sweepTextScenarioPreviewActivity, View view) {
        sweepTextScenarioPreviewActivity.finish();
    }

    public final TextView B(String text) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(w());
        textView.setText(text);
        textView.setTextSize(13.0f);
        textView.setTextColor(Color.parseColor("#B3FFFFFF"));
        textView.setLineSpacing(A(2), 1.0f);
        textView.setBackground(I());
        textView.setPadding(A(12), A(10), A(12), A(10));
        return textView;
    }

    public final View C(String taskId) {
        FrameLayout frameLayout = new FrameLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(D(), -2);
        layoutParams.gravity = 1;
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setPadding(0, A(10), 0, A(16));
        frameLayout.addView(new TaskInfoCardMediumView(this, taskId), new FrameLayout.LayoutParams(-1, -2, 1));
        return frameLayout;
    }

    public final int D() {
        return Math.min(A(FIGMA_MEDIUM_CARD_WIDTH_DP), getResources().getDisplayMetrics().widthPixels - A(16));
    }

    public final List<MediumPreviewCase> E() {
        return C1173v.p(new MediumPreviewCase("Running · 约 186dp 基础态", "header + cvr，无按钮", m.MEDIUM_TASK_ID), new MediumPreviewCase("Completed · 约 186dp 基础态", "终态隐藏 toolcall，保留 cvr", m.MEDIUM_COMPLETED_TASK_ID), new MediumPreviewCase("Failed · 约 146dp 按钮态", "隐藏 cvr，展示全宽查看详情", m.MEDIUM_FAILED_TASK_ID), new MediumPreviewCase("Waiting · 单按钮约 246dp", "header + cvr + 16dp gap + 全宽主按钮", m.MEDIUM_SINGLE_ACTION_TASK_ID), new MediumPreviewCase("Waiting · 双按钮", "两个 152dp 按钮，中间 16dp gap", m.MEDIUM_DOUBLE_ACTION_TASK_ID), new MediumPreviewCase("Waiting · 三按钮约 350dp", "Figma 5516:47825，三枚 320x44 选项按钮", m.MEDIUM_PENDING_QUESTION_TASK_ID), new MediumPreviewCase("Waiting · 选项溢出兜底", "4 个选项收敛为全宽查看详情", m.MEDIUM_OVERFLOW_ACTION_TASK_ID));
    }

    public final void F(Throwable error) {
        LinearLayout linearLayout = this.content;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LinearLayout linearLayout3 = this.content;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        } else {
            linearLayout2 = linearLayout3;
        }
        int i10 = R$string.task_sweep_scenario_preview_failed;
        String message = error.getMessage();
        if (message == null) {
            message = error.getClass().getSimpleName();
        }
        String string = getString(i10, message);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        linearLayout2.addView(B(string));
    }

    public final void G() {
        LinearLayout linearLayout = this.content;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LinearLayout linearLayout3 = this.content;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        } else {
            linearLayout2 = linearLayout3;
        }
        String string = getString(R$string.task_sweep_scenario_preview_loading);
        kotlin.jvm.internal.p.h(string, "getString(...)");
        linearLayout2.addView(J(string));
    }

    public final void H(int written) {
        LinearLayout linearLayout = this.content;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            linearLayout = null;
        }
        linearLayout.removeAllViews();
        LinearLayout linearLayout3 = this.content;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            linearLayout3 = null;
        }
        String string = getString(R$string.task_sweep_scenario_preview_seed_done, Integer.valueOf(written));
        kotlin.jvm.internal.p.h(string, "getString(...)");
        linearLayout3.addView(B(string));
        LinearLayout linearLayout4 = this.content;
        if (linearLayout4 == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            linearLayout4 = null;
        }
        linearLayout4.addView(J("TaskStore 中卡视觉状态"));
        for (MediumPreviewCase mediumPreviewCase : E()) {
            LinearLayout linearLayout5 = this.content;
            if (linearLayout5 == null) {
                kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
                linearLayout5 = null;
            }
            linearLayout5.addView(v(mediumPreviewCase.getTitle(), mediumPreviewCase.getNote()));
            LinearLayout linearLayout6 = this.content;
            if (linearLayout6 == null) {
                kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
                linearLayout6 = null;
            }
            linearLayout6.addView(C(mediumPreviewCase.getTaskId()));
        }
        LinearLayout linearLayout7 = this.content;
        if (linearLayout7 == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
            linearLayout7 = null;
        }
        String string2 = getString(R$string.task_sweep_scenario_preview_entries_title);
        kotlin.jvm.internal.p.h(string2, "getString(...)");
        linearLayout7.addView(J(string2));
        LinearLayout linearLayout8 = this.content;
        if (linearLayout8 == null) {
            kotlin.jvm.internal.p.A(SkillStoreKt.SKILL_DOC_TYPE_CONTENT);
        } else {
            linearLayout2 = linearLayout8;
        }
        String string3 = getString(R$string.task_sweep_scenario_preview_entries);
        kotlin.jvm.internal.p.h(string3, "getString(...)");
        linearLayout2.addView(B(string3));
    }

    public final GradientDrawable I() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(A(8));
        gradientDrawable.setColor(Color.parseColor("#14FFFFFF"));
        gradientDrawable.setStroke(1, Color.parseColor("#22FFFFFF"));
        return gradientDrawable;
    }

    public final TextView J(String text) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(w());
        textView.setText(text);
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(-1);
        textView.setPadding(0, A(14), 0, A(8));
        return textView;
    }

    public final void K() {
        G();
        C1060i.d(this.scope, null, null, new SweepTextScenarioPreviewActivity$seedAndRender$1(this, null), 3, null);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(x());
        K();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
        super.onDestroy();
    }

    public final TextView v(String title, String note) {
        TextView textView = new TextView(this);
        textView.setLayoutParams(w());
        textView.setText(title + "\n" + note);
        textView.setTextSize(13.0f);
        textView.setTextColor(Color.parseColor("#CCFFFFFF"));
        textView.setLineSpacing((float) A(2), 1.0f);
        textView.setPadding(0, A(10), 0, A(6));
        return textView;
    }

    public final LinearLayout.LayoutParams w() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMarginStart(A(20));
        layoutParams.setMarginEnd(A(20));
        return layoutParams;
    }
}
