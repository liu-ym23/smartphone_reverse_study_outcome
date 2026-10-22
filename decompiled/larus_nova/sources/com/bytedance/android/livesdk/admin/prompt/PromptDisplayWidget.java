package com.bytedance.android.livesdk.admin.prompt;

import am2.x;
import android.animation.AnimatorSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.h;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.ni;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.live.datacontext.DataContext;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/admin/prompt/PromptDisplayWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Landroid/view/View$OnClickListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromptDisplayWidget extends LiveWidget implements View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f103074e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f103075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f103076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ni f103077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f103078d;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromptDisplayWidget f103079a;

        public b(PromptDisplayWidget r100) {
            this.f103079a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            PromptDisplayWidget r102 = this.f103079a;
            int r103 = PromptDisplayWidget.f103074e;
            r102.xq().promptShowComplete();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PromptDisplayWidget f103080a;

        public c(PromptDisplayWidget r100) {
            this.f103080a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            PromptDisplayWidget r101 = this.f103080a;
            ni r102 = (ni) sh6.c.b((sh6.b) r100);
            int r103 = PromptDisplayWidget.f103074e;
            r101.yq(r102);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_dialog_teleprompt;
    }

    public final PrompterDataContext xq() {
        return (PrompterDataContext) this.f103078d.getValue();
    }

    public PromptDisplayWidget() {
        this.f103075a = new CompositeDisposable();
        this.f103078d = InfraKotlinExtsKt.mainThreadLazy(new PromptDisplayWidget$dataContext$2(this));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        yq(null);
        Disposable r100 = xq().getShowingPrompt().a().subscribe(new c(this));
        if (r100 == null) goto L6;
        this.f103075a.add(r100);
    L6:
        if (this.isViewValid == false) goto L8;
        this.containerView.removeAllViews();
    L8:
        xq().fetch();
        this.contentView.setPivotX(this.containerView.getWidth() / 2.0f);
        this.contentView.setPivotY(this.containerView.getHeight() / 2.0f);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        DataContext r100 = com.bytedance.live.datacontext.d.d(PrompterDataContext.TAG);
        if ((r100 instanceof PrompterDataContext) == true) goto L5;
        r100 = null;
    L5:
        PrompterDataContext r101 = (PrompterDataContext) r100;
        if (r101 == null) goto L13;
        Set<PrompterDataContext.b> r102 = r101.getValidPrompters();
        if (r102 == null) goto L13;
        Iterator<T> r103 = r102.iterator();
    L11:
        if (r103.hasNext() == false) goto L13;
        PrompterDataContext.b r104 = (PrompterDataContext.b) r103.next();
        g r105 = u.l();
        PrompterDataContext.a r106 = PrompterDataContext.Companion;
        User r107 = r104.f103082b;
        r106.getClass();
        r105.f("livesdk_valid_prompter", PrompterDataContext.a.b(r107), new Object[]{Room.class, x.class});
    L13:
        this.f103075a.clear();
        Disposable r108 = this.f103076b;
        if (r108 == null) goto L18;
        r108.dispose();
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        User r101 = null;
        if (r100.getId() != R.id.tv_prompt_send_by) goto L12;
        ni r102 = xq().getShowingPrompt().getValue();
        if (r102 == null) goto L8;
        r101 = r102.E();
    L8:
        if (r101 != null) goto L10;
        return;
    L10:
        UserProfileEvent r103 = new UserProfileEvent(r101);
        this.dataCenter.put("cmd_show_user_profile", r103);
        return;
    L12:
        if (r100.getId() != R.id.iv_close) goto L19;
        Disposable r104 = this.f103076b;
        if (r104 == null) goto L16;
        r104.dispose();
    L16:
        yq(null);
        xq().promptShowComplete();
        return;
    }

    public final void wq(ni r100) {
        TextView r101 = (TextView) findViewById(R.id.tv_prompt_send_by);
        if (r101 == null) goto L5;
        r101.setText(r100.E().getRealNickName());
        r101.setOnClickListener(this);
    L5:
        TextView r102 = (TextView) findViewById(R.id.tv_prompt_content);
        if (r102 == null) goto L8;
        r102.setText(r100.getContent());
    L8:
        ImageView r103 = (ImageView) findViewById(R.id.iv_close);
        if (r103 == null) goto L12;
        r103.setOnClickListener(this);
    L12:
        if (r100.getDuration() > 0) goto L14;
        r100.setDuration(10);
        ALogger.w("PromptDisplayWidget", "prompt duration <= 0, force changed to " + r100.getDuration());
    L14:
        Disposable r104 = this.f103076b;
        if (r104 == null) goto L17;
        r104.dispose();
    L17:
        this.f103076b = Observable.timer(r100.getDuration(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this));
        xq().logPV("livesdk_prompt_panel_show");
    }

    public final void yq(ni r100) {
        ALogger.i("PromptDisplayWidget", "prompt update: " + this.f103077c + " -> " + r100);
        ni r101 = this.f103077c;
        if (this.isViewValid == false) goto L21;
        if (r101 != null) goto L9;
        if (r100 == null) goto L21;
    L9:
        if (this.containerView.getChildCount() > 0) goto L12;
        View r102 = LayoutInflater.from(this.contentView.getContext()).inflate(R.layout.ttlive_dialog_teleprompt, this.containerView, false);
        this.contentView = r102;
        this.containerView.addView(r102);
    L12:
        if (r101 != null) goto L15;
        if (r100 == null) goto L15;
        this.contentView.setScaleX(0.0f);
        this.contentView.setScaleY(0.0f);
        this.contentView.setVisibility(0);
        AnimatorSet r103 = h.c(this.contentView, new float[]{1.0f});
        r103.setDuration(250);
        r103.start();
        wq(r100);
    L15:
        if (r101 == null) goto L18;
        if (r100 != null) goto L18;
        this.contentView.setScaleX(1.0f);
        this.contentView.setScaleY(1.0f);
        AnimatorSet r104 = h.c(this.contentView, new float[]{0.0f});
        r104.setDuration(250);
        r104.addListener(new com.bytedance.android.livesdk.admin.prompt.a(this));
        r104.start();
    L18:
        if (r101 == null) goto L21;
        if (r100 == null) goto L21;
        View r105 = this.contentView;
        int r106 = r105.findViewById(R.id.tv_prompt_content).getHeight();
        View r107 = LayoutInflater.from(this.contentView.getContext()).inflate(R.layout.ttlive_dialog_teleprompt, this.containerView, false);
        r107.setAlpha(0.0f);
        this.contentView = r107;
        this.containerView.addView(r107);
        wq(r100);
        r107.post(new com.bytedance.android.livesdk.admin.prompt.b(this, r107, r106, r105));
        r105.animate().alpha(0.0f).setDuration(200).setListener(new com.bytedance.android.livesdk.admin.prompt.c(this, r105)).start();
    L21:
        this.f103077c = r100;
    }
}
