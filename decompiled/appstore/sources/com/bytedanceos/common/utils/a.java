package com.bytedanceos.common.utils;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.TransitionDrawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$anim;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$id;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.R$style;
import com.bytedanceos.common.core.ui.presenter.APresenter;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.CommentInfo;
import com.bytedanceos.common.model.CommentParams;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.cache.AccountDataCache;
import com.bytedanceos.common.toolbox.e0;
import com.bytedanceos.common.ui.ConfirmDialog;
import com.bytedanceos.common.ui.dialog.AddCommentDialog;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AddCommentDialog f10184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public APresenter f10185b;

    /* JADX INFO: renamed from: com.bytedanceos.common.utils.a$a, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0136a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f10186a;

        public DialogInterfaceOnClickListenerC0136a(a r10) {
            this.f10186a = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.cancel();
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f10187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f10188b;

        public b(a r10, Activity r11) {
            this.f10188b = r10;
            this.f10187a = r11;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r10, int r11) {
            r10.dismiss();
            com.bytedanceos.common.toolbox.e.l1(this.f10187a, 1);
        }
    }

    public class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentInfo f10189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f10190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f10191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f10192d;

        public c(a r10, CommentInfo r11, ImageView r12, View r13) {
            this.f10192d = r10;
            this.f10189a = r11;
            this.f10190b = r12;
            this.f10191c = r13;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r10) {
            this.f10189a.isSupporting = true;
            TransitionDrawable r11 = f.f(R$drawable.comment_support);
            this.f10190b.setImageDrawable(r11);
            r11.startTransition(50);
            CommentParams r12 = CommentParams.convertParams(this.f10189a);
            r12.mCookie = this.f10191c;
            a.a(this.f10192d).e(700012, null, r12);
        }
    }

    public class d implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentInfo f10193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f10194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f10195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f10196d;

        public d(a r10, CommentInfo r11, ImageView r12, View r13) {
            this.f10196d = r10;
            this.f10193a = r11;
            this.f10194b = r12;
            this.f10195c = r13;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r10) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r10) {
            this.f10193a.isSupporting = true;
            TransitionDrawable r11 = f.f(R$drawable.comment_support_done);
            this.f10194b.setImageDrawable(r11);
            r11.startTransition(50);
            CommentParams r12 = CommentParams.convertParams(this.f10193a);
            r12.mCookie = this.f10195c;
            a.a(this.f10196d).e(700010, null, r12);
        }
    }

    public a(APresenter r10) {
        this.f10185b = r10;
    }

    public static /* synthetic */ APresenter a(a r10) {
        return r10.f10185b;
    }

    public void b(Activity r10, AppInfo r11) {
        boolean r12 = BaseApplication.c().b().b0(r11.appPackageName);
        if (BaseApplication.c().b().b0(r11.appPackageName) == true) goto L6;
        d9.a.e().j(true, false, r11.appPackageName);
        e0.e(R$string.add_comment_no_buy);
        return;
    L6:
        if (AccountDataCache.b().n() == true) goto L9;
        d9.a.e().j(false, r12, r11.appPackageName);
        ConfirmDialog.newInstance(26, true, null, true, r10.getResources().getString(R$string.add_comment_no_user)).show(r10.getFragmentManager(), "NO_LOGIN_DIALOG");
        return;
    L9:
        if (TextUtils.isEmpty(AccountDataCache.b().f()) == false) goto L11;
        new AlertDialog.Builder(new ContextThemeWrapper(r10, R$style.AppStoreDialogTheme)).setTitle(R$string.nickname_alert_title).setMessage(R$string.nickname_alert_context).setPositiveButton(R$string.nickname_settings, new b(this, r10)).setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC0136a(this)).create().show();
        return;
    L11:
        d9.a.e().j(true, true, r11.appPackageName);
        CommentParams r13 = CommentParams.convertParams(r11);
        this.f10185b.e(700008, r11, r13);
    }

    public void c() {
    }

    public void d(String r10, AppStoreCommonError r11, Object r12) {
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r12 instanceof View) == false) goto L48;
        View r13 = (View) r12;
        JSONObject r14 = new JSONObject(r10);     // Catch: Throwable -> L27 Exception -> L29
        if (r14.isNull(ServerElements.BODY) == false) goto L10;
        return;
    L10:
        if (r14.getJSONObject(ServerElements.BODY).length() != 0) goto L15;
        TransitionDrawable r15 = com.bytedanceos.common.toolbox.e.d0(R$drawable.comment_support);
        ((ImageView) r13.findViewById(R$id.comment_item_support_icon)).setImageDrawable(r15);
        r15.startTransition(50);
        CommentInfo r16 = (CommentInfo) r13.getTag(R$id.support_comment_info);
        if (r16 == null) goto L46;
        r16.isSupporting = false;
        r16.isLike = false;
        return;
    L46:
        return;
    L15:
        int r17 = r14.getJSONObject(ServerElements.BODY).optInt("app_id", 0);     // Catch: Throwable -> L27 Exception -> L29
        int r18 = r14.getJSONObject(ServerElements.BODY).optInt("comment_id", 0);     // Catch: Throwable -> L27 Exception -> L29
        TextView r19 = (TextView) r13.findViewById(R$id.comment_item_support_times);     // Catch: Throwable -> L27 Exception -> L29
        int r20 = R$id.support_comment_info;     // Catch: Throwable -> L27 Exception -> L29
        CommentInfo r21 = (CommentInfo) r13.getTag(r20);     // Catch: Throwable -> L27 Exception -> L29
        r21.isSupporting = false;     // Catch: Throwable -> L27 Exception -> L29
        if (r21.app_id == r17) goto L18;
        return;
    L18:
        if (r21.comment_id != r18) goto L47;
        if (r11 == null) goto L32;
        if (r11.getErrorCode() == 1008005) goto L32;
        TransitionDrawable r22 = com.bytedanceos.common.toolbox.e.d0(R$drawable.comment_support);
        ((ImageView) r13.findViewById(R$id.comment_item_support_icon)).setImageDrawable(r22);
        r22.startTransition(50);
        CommentInfo r23 = (CommentInfo) r13.getTag(r20);
        if (r23 == null) goto L50;
    L26:
        r23.isSupporting = false;
        r23.isLike = false;
        return;
    L50:
        return;
    L32:
        r21.isLike = true;     // Catch: Throwable -> L27 Exception -> L29
        r21.commentSupportTimes++;     // Catch: Throwable -> L27 Exception -> L29
        r19.setVisibility(0);     // Catch: Throwable -> L27 Exception -> L29
        r19.setTextColor(BaseApplication.c().getResources().getColorStateList(R$color.color_d4));     // Catch: Throwable -> L27 Exception -> L29
        int r24 = r21.commentSupportTimes;     // Catch: Throwable -> L27 Exception -> L29
        if (r24 <= 9999) goto L35;
        String r25 = "9999+";
    L36:
        r19.setText(r25);     // Catch: Throwable -> L27 Exception -> L29
    L53:
        return;
    L35:
        r25 = String.valueOf(r24);     // Catch: Throwable -> L27 Exception -> L29
        goto L36
    L47:
        return;
    L29:
        e = move-exception;
        e.printStackTrace();
        TransitionDrawable r26 = com.bytedanceos.common.toolbox.e.d0(R$drawable.comment_support);
        ((ImageView) r13.findViewById(R$id.comment_item_support_icon)).setImageDrawable(r26);
        r26.startTransition(50);
        r23 = (CommentInfo) r13.getTag(R$id.support_comment_info);
        if (r23 != null) goto L26;
        return;
    L27:
        th = move-exception;
        throw th;
    }

    public void e(String r10, AppStoreCommonError r11, Object r12) {
        if (r12 != null) goto L5;
        return;
    L5:
        if ((r12 instanceof View) == false) goto L49;
        View r13 = (View) r12;
        JSONObject r14 = new JSONObject(r10);     // Catch: Throwable -> L27 Exception -> L29
        if (r14.isNull(ServerElements.BODY) == false) goto L10;
        return;
    L10:
        if (r14.getJSONObject(ServerElements.BODY).length() != 0) goto L15;
        TransitionDrawable r15 = com.bytedanceos.common.toolbox.e.d0(R$drawable.comment_support_done);
        ((ImageView) r13.findViewById(R$id.comment_item_support_icon)).setImageDrawable(r15);
        r15.startTransition(50);
        CommentInfo r16 = (CommentInfo) r13.getTag(R$id.support_comment_info);
        if (r16 == null) goto L47;
        r16.isSupporting = false;
        r16.isLike = true;
        return;
    L47:
        return;
    L15:
        int r17 = r14.getJSONObject(ServerElements.BODY).optInt("app_id", 0);     // Catch: Throwable -> L27 Exception -> L29
        int r18 = r14.getJSONObject(ServerElements.BODY).optInt("comment_id", 0);     // Catch: Throwable -> L27 Exception -> L29
        TextView r19 = (TextView) r13.findViewById(R$id.comment_item_support_times);     // Catch: Throwable -> L27 Exception -> L29
        int r20 = R$id.support_comment_info;     // Catch: Throwable -> L27 Exception -> L29
        CommentInfo r21 = (CommentInfo) r13.getTag(r20);     // Catch: Throwable -> L27 Exception -> L29
        r21.isSupporting = false;     // Catch: Throwable -> L27 Exception -> L29
        if (r21.app_id == r17) goto L18;
        return;
    L18:
        if (r21.comment_id != r18) goto L48;
        if (r11 != null) goto L22;
    L31:
        r21.isLike = false;     // Catch: Throwable -> L27 Exception -> L29
        int r22 = r21.commentSupportTimes - 1;     // Catch: Throwable -> L27 Exception -> L29
        r21.commentSupportTimes = r22;     // Catch: Throwable -> L27 Exception -> L29
        if (r22 > 0) goto L34;
        r19.setVisibility(4);     // Catch: Throwable -> L27 Exception -> L29
        return;
    L34:
        r19.setVisibility(0);     // Catch: Throwable -> L27 Exception -> L29
        r19.setTextColor(BaseApplication.c().getResources().getColorStateList(R$color.color_9));     // Catch: Throwable -> L27 Exception -> L29
        int r23 = r21.commentSupportTimes;     // Catch: Throwable -> L27 Exception -> L29
        if (r23 <= 9999) goto L37;
        String r24 = "9999+";
    L38:
        r19.setText(r24);     // Catch: Throwable -> L27 Exception -> L29
        return;
    L37:
        r24 = String.valueOf(r23);     // Catch: Throwable -> L27 Exception -> L29
        goto L38
    L22:
        if (r11.getErrorCode() == 1008007) goto L31;
        TransitionDrawable r25 = com.bytedanceos.common.toolbox.e.d0(R$drawable.comment_support_done);
        ((ImageView) r13.findViewById(R$id.comment_item_support_icon)).setImageDrawable(r25);
        r25.startTransition(50);
        CommentInfo r26 = (CommentInfo) r13.getTag(r20);
        if (r26 == null) goto L51;
    L26:
        r26.isSupporting = false;
        r26.isLike = true;
        return;
    L51:
        return;
    L48:
        return;
    L29:
        e = move-exception;
        e.printStackTrace();
        TransitionDrawable r27 = com.bytedanceos.common.toolbox.e.d0(R$drawable.comment_support_done);
        ((ImageView) r13.findViewById(R$id.comment_item_support_icon)).setImageDrawable(r27);
        r27.startTransition(50);
        r26 = (CommentInfo) r13.getTag(R$id.support_comment_info);
        if (r26 != null) goto L26;
        return;
    L27:
        th = move-exception;
        throw th;
    }

    public void f(boolean r10, AppInfo r11, APresenter.b r12) {
        AddCommentDialog r13 = this.f10184a;
        if (r13 == null) goto L5;
        r13.dismiss();
        this.f10184a = null;
    L5:
        if (r10 == true) goto L7;
        e0.g(n.a(BaseApplication.c(), r12.f9800a, r12.f9801b).getErrorMsg());
        return;
    L7:
        e0.e(R$string.add_comment_success);
    }

    public void g(Activity r10, AppInfo r11, boolean r12, String r13) {
        c();
        if (r12 == false) goto L5;
        CommentInfo r14 = c9.a.j(r13);
        AddCommentDialog r15 = new AddCommentDialog(r10, R$style.dialog_comment, this.f10185b);
        this.f10184a = r15;
        r15.setPackageName(r11.appPackageName);
        this.f10184a.setData(r14.content, String.valueOf(r14.score));
        this.f10184a.getWindow().setSoftInputMode(5);
        this.f10184a.show();
        return;
    L5:
        e0.e(R$string.SOCKET_TIME_OUT);
    }

    public void h(View r10) {
        int r11 = R$id.support_comment_info;
        if (r10.getTag(r11) != null) goto L5;
        return;
    L5:
        CommentInfo r12 = (CommentInfo) r10.getTag(r11);
        if (r12.isLike == false) goto L15;
        if (r12.isSupporting == false) goto L10;
        return;
    L10:
        if (TextUtils.equals(r12.user, AccountDataCache.b().k()) == true) goto L21;
        ImageView r13 = (ImageView) r10.findViewById(R$id.comment_item_support_icon);
        Animation r14 = AnimationUtils.loadAnimation(BaseApplication.c(), R$anim.support_comments);
        r14.setAnimationListener(new c(this, r12, r13, r10));
        r13.startAnimation(r14);
        return;
    L21:
        return;
    L15:
        if (r12.isSupporting == false) goto L17;
        return;
    L17:
        if (r12.isMyComment == true) goto L24;
        ImageView r15 = (ImageView) r10.findViewById(R$id.comment_item_support_icon);
        new StringBuilder(r12.app_id);
        Animation r16 = AnimationUtils.loadAnimation(BaseApplication.c(), R$anim.support_comments);
        r16.setAnimationListener(new d(this, r12, r15, r10));
        r15.startAnimation(r16);
        return;
    }
}
