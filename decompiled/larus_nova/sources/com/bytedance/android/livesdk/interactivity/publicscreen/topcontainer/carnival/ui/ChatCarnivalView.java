package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.carnival.ui;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.test.CarnivalAutoTestUtil;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/carnival/ui/ChatCarnivalView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/a;", "msg", "", "setCurrentMsg", "getCurrentMsg", "Landroid/widget/ImageView;", "getChatCarnivalImgTitle", "getChatCarnivalBg", "getChatCarnivalBgBlack", "Landroid/widget/TextView;", "getChatCarnivalContent", "getCarnivalBtn", "", "getCurrentBgColor", "", "getTimeLeft", "()J", "timeLeft", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChatCarnivalView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.barrage.model.a f139746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f139747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f139748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.b f139749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f139750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f139751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f139752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HSImageView f139753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ImageView f139754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f139755j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f139756k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final HSImageView f139757l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f139758m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DraweeController f139759n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public DraweeController f139760o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SimpleDateFormat f139761p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f139762q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f139763r;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HSImageView f139764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatCarnivalView f139765b;

        public b(HSImageView r100, ChatCarnivalView r101) {
            this.f139764a = r100;
            this.f139765b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ChatCarnivalView r101 = this.f139765b;
            PipelineDraweeControllerBuilder r102 = Fresco.newDraweeControllerBuilder();
            r101.f139760o = r102.setUri((Uri) r100).setAutoPlayAnimations(true).build();
            this.f139764a.setController(this.f139765b.f139760o);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f139766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChatCarnivalView f139767b;

        public c(Ref.LongRef r100, ChatCarnivalView r101) {
            this.f139766a = r100;
            this.f139767b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            long r102 = this.f139766a.element;
            if (r102 <= 0) goto L6;
            String r103 = this.f139767b.f139761p.format(Long.valueOf(r102));
            TextView r104 = this.f139767b.f139756k;
            StringCompanionObject r105 = StringCompanionObject.INSTANCE;
            r104.setText(String.format("%1s", Arrays.copyOf(new Object[]{r103}, 1)));
            this.f139766a.element -= 1000;
            return;
        }
    }

    static {
    }

    public ChatCarnivalView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChatCarnivalView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final long getTimeLeft() {
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100 = this.f139746a;
        if (r100 == null) goto L5;
        long r101 = r100.n();
    L7:
        return ((r101 / 1000) + 1) * 1000;
    L5:
        r101 = 0;
        goto L7
    }

    public final ImageView getCarnivalBtn() {
        return this.f139758m;
    }

    public final ImageView getChatCarnivalBg() {
        return this.f139751f;
    }

    public final ImageView getChatCarnivalBgBlack() {
        return this.f139752g;
    }

    public final TextView getChatCarnivalContent() {
        return this.f139755j;
    }

    public final ImageView getChatCarnivalImgTitle() {
        return this.f139754i;
    }

    public final int getCurrentBgColor() {
        return this.f139747b;
    }

    public final com.bytedance.android.livesdk.interactivity.api.barrage.model.a getCurrentMsg() {
        return this.f139746a;
    }

    public final void a(boolean r100) {
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r101 = this.f139746a;
        if ((r101 instanceof j) == true) goto L5;
        r101 = null;
    L5:
        j r102 = (j) r101;
        if (r102 == null) goto L27;
        UtilityKotlinExtentionsKt.t(this.f139757l);
        UtilityKotlinExtentionsKt.t(this.f139758m);
        UtilityKotlinExtentionsKt.w(this.f139754i);
        UtilityKotlinExtentionsKt.w(this.f139756k);
        if (r100 == false) goto L16;
        HSImageView r103 = this.f139753h;
        this.f139750e.add(Observable.create(new oa2.b(this)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(r103, this)));
        if (r102.A() != 1) goto L12;
        int r104 = 0;
    L13:
        r103.setVisibility(r104);
        k r105 = r102.D();
        if (r105 == null) goto L16;
        ImageUtil.loadImage(this.f139754i, r105, 0);
        goto L16
    L12:
        r104 = 8;
    L16:
        String r106 = r102.r();
        if (r106 == null) goto L25;
        TextView r107 = this.f139755j;
        r107.setText(r106);
        r107.setPadding(0, 0, 0, 0);
        if (v.a() == false) goto L25;
        if (CarnivalAutoTestUtil.f133551a == false) goto L25;
        if (CarnivalAutoTestUtil.a() == null) goto L25;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
    L25:
        Ref.LongRef r108 = new Ref.LongRef();
        long r109 = getTimeLeft();
        r108.element = r109;
        String.valueOf(r109);
        Disposable r110 = Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r108, this));
        this.f139750e.add(r110);
        return;
    }

    public final void setCurrentMsg(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r100) {
        this.f139746a = r100;
    }

    public ChatCarnivalView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f139747b = ColorProtector.parseColor("#FF308A");
        this.f139748c = true;
        this.f139750e = new CompositeDisposable();
        this.f139761p = new SimpleDateFormat("mm:ss", Locale.CHINA);
        LayoutInflater.from(r100).inflate(R.layout.ttlive_view_chat_carnival, this);
        this.f139751f = (ImageView) findViewById(R.id.chat_carnival_bg);
        this.f139752g = (ImageView) findViewById(R.id.chat_carnival_bg_black);
        this.f139753h = (HSImageView) findViewById(R.id.chat_carnival_red_ball);
        this.f139754i = (ImageView) findViewById(R.id.chat_carnival_img_title);
        this.f139755j = (TextView) findViewById(R.id.chat_carnival_msg_content);
        this.f139756k = (TextView) findViewById(R.id.carnival_countdown);
        this.f139757l = (HSImageView) findViewById(R.id.chat_carnival_loading);
        this.f139758m = (ImageView) findViewById(R.id.chat_carnival_img_end);
        this.f139762q = i2.b("/comment/ttlive_red_ball_chat_carnival.webp");
        this.f139763r = i2.b("/comment/ttlive_loading_chat_carnival.webp");
    }

    public /* synthetic */ ChatCarnivalView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
