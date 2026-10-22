package com.stepos.agentframework.chatui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.navigation.NavigationView;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.chatcore.Configuration;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.agentframework.chatcore.session.AgentSession;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.AbstractActivityC2019j;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.appui.LocalAppUIHostView;
import com.stepos.agentframework.chatui.task.view.TaskPanel;
import com.stepos.agentframework.util.C2154c;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import u4.AgentTask;
import u4.AgentTaskComplete;
import u4.AgentTaskError;
import u4.AgentTaskEvent;
import u4.AgentTaskPlan;
import w4.ChatMessage;
import y4.InterfaceC5941c;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 p2\u00020\u0001:\u0003qrsB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u0003J\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\u0003J\u000f\u0010\u001f\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u001f\u0010\u0003J\u000f\u0010 \u001a\u00020\u0004H\u0015¢\u0006\u0004\b \u0010\u0003J\u0015\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0007¢\u0006\u0004\b)\u0010\nR\u0014\u0010+\u001a\u00020*8\u0002X\u0082D¢\u0006\u0006\n\u0004\b+\u0010,R(\u0010.\u001a\b\u0018\u00010-R\u00020\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010J\u001a\u00020I8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010Q\u001a\u00020P8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010_\u001a\u00020^8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010f\u001a\u00020e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0014\u0010o\u001a\u00020l8&X¦\u0004¢\u0006\u0006\u001a\u0004\bm\u0010n¨\u0006t"}, d2 = {"Lcom/stepos/agentframework/chatui/j;", "Landroidx/appcompat/app/d;", "<init>", "()V", "LY8/t;", "v", "U", "Landroid/view/View;", "openClickView", "setUpDrawerOpenViewClick", "(Landroid/view/View;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "layoutResID", "setContentView", "(I)V", "Lcom/stepos/agentframework/chatcore/Configuration;", "configuration", "Lcom/stepos/agentframework/AgentUIConfig;", "appUIConfig", "H", "(Lcom/stepos/agentframework/chatcore/Configuration;Lcom/stepos/agentframework/AgentUIConfig;)V", "w", "I", "J", "onDestroy", "Lu4/i;", "task", ExifInterface.LONGITUDE_WEST, "(Lu4/i;)V", "Lu4/e;", "X", "(Lu4/e;)V", "view", "slideInFromRight", "", "TAG", "Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/j$c;", "drawerHelper", "Lcom/stepos/agentframework/chatui/j$c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/stepos/agentframework/chatui/j$c;", "setDrawerHelper", "(Lcom/stepos/agentframework/chatui/j$c;)V", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", "chatLayout", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", "z", "()Lcom/stepos/agentframework/chatui/AgentChatLayout;", "M", "(Lcom/stepos/agentframework/chatui/AgentChatLayout;)V", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "sessionHandler", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "D", "()Lcom/stepos/agentframework/chatcore/SessionHandler;", "P", "(Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mainLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "C", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "O", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "Lcom/stepos/agentframework/chatui/appui/LocalAppUIHostView;", "appUIViewHost", "Lcom/stepos/agentframework/chatui/appui/LocalAppUIHostView;", "y", "()Lcom/stepos/agentframework/chatui/appui/LocalAppUIHostView;", "L", "(Lcom/stepos/agentframework/chatui/appui/LocalAppUIHostView;)V", "Lcom/stepos/agentframework/chatui/InputLayout;", "inputLayout", "Lcom/stepos/agentframework/chatui/InputLayout;", "B", "()Lcom/stepos/agentframework/chatui/InputLayout;", "N", "(Lcom/stepos/agentframework/chatui/InputLayout;)V", "Lcom/stepos/agentframework/chatui/AgentToolBar;", "toolBar", "Lcom/stepos/agentframework/chatui/AgentToolBar;", "G", "()Lcom/stepos/agentframework/chatui/AgentToolBar;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatui/AgentToolBar;)V", "Landroid/widget/ImageView;", "taskOnOff", "Landroid/widget/ImageView;", ExifInterface.LONGITUDE_EAST, "()Landroid/widget/ImageView;", "Q", "(Landroid/widget/ImageView;)V", "Lcom/stepos/agentframework/chatui/task/view/TaskPanel;", "taskPanel", "Lcom/stepos/agentframework/chatui/task/view/TaskPanel;", "F", "()Lcom/stepos/agentframework/chatui/task/view/TaskPanel;", "R", "(Lcom/stepos/agentframework/chatui/task/view/TaskPanel;)V", "Lcom/stepos/agentframework/chatui/j$a;", "x", "()Lcom/stepos/agentframework/chatui/j$a;", "agentChatConfig", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractActivityC2019j extends androidx.appcompat.app.d {
    public static final String EXTRA_FORCE_NEW_SESSION = "extra_force_new_session";
    private final String TAG = "AgentChatBaseActivity";
    public LocalAppUIHostView appUIViewHost;
    public AgentChatLayout chatLayout;
    private c drawerHelper;
    public InputLayout inputLayout;
    public ConstraintLayout mainLayout;
    public SessionHandler sessionHandler;
    public ImageView taskOnOff;
    public TaskPanel taskPanel;
    public AgentToolBar toolBar;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/agentframework/chatui/j$c;", "", "<init>", "(Lcom/stepos/agentframework/chatui/j;)V", "LY8/t;", "c", "()V", "", "drawerNavigationLayoutId", "f", "(I)V", "Landroidx/drawerlayout/widget/DrawerLayout;", "rootDrawer", "Landroidx/drawerlayout/widget/DrawerLayout;", "e", "()Landroidx/drawerlayout/widget/DrawerLayout;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/drawerlayout/widget/DrawerLayout;)V", "Lcom/google/android/material/navigation/NavigationView;", "navigationView", "Lcom/google/android/material/navigation/NavigationView;", Const.INTENT_KEY_UMID, "()Lcom/google/android/material/navigation/NavigationView;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/google/android/material/navigation/NavigationView;)V", "Landroid/view/View;", "mask", "Landroid/view/View;", "navigationContent", "getNavigationContent", "()Landroid/view/View;", "setNavigationContent", "(Landroid/view/View;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.j$c */
    public final class c {
        private View mask;
        private View navigationContent;
        public NavigationView navigationView;
        public DrawerLayout rootDrawer;

        @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/stepos/agentframework/chatui/j$c$a", "Landroidx/drawerlayout/widget/DrawerLayout$e;", "Landroid/view/View;", "drawerView", "", "slideOffset", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/view/View;F)V", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)V", Const.INTENT_KEY_PKGNAME, "", "newState", "c", "(I)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentframework.chatui.j$c$a */
        public static final class a implements DrawerLayout.e {
            final /* synthetic */ AbstractActivityC2019j this$1;

            public a(AbstractActivityC2019j abstractActivityC2019j) {
                this.this$1 = abstractActivityC2019j;
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.e
            public void a(View drawerView) {
                kotlin.jvm.internal.p.i(drawerView, "drawerView");
                this.this$1.x().j().invoke();
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.e
            public void b(View drawerView) {
                kotlin.jvm.internal.p.i(drawerView, "drawerView");
                this.this$1.z().setTranslationX(0.0f);
                View view = c.this.mask;
                if (view == null) {
                    kotlin.jvm.internal.p.A("mask");
                    view = null;
                }
                view.setAlpha(0.0f);
                this.this$1.x().i().invoke();
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.e
            public void c(int newState) {
            }

            @Override // androidx.drawerlayout.widget.DrawerLayout.e
            public void d(View drawerView, float slideOffset) {
                kotlin.jvm.internal.p.i(drawerView, "drawerView");
                float width = drawerView.getWidth() * slideOffset;
                View view = c.this.mask;
                if (view == null) {
                    kotlin.jvm.internal.p.A("mask");
                    view = null;
                }
                view.setAlpha(slideOffset * 0.5f);
                if (drawerView.getLayoutDirection() == 0) {
                    this.this$1.z().setTranslationX(width);
                } else {
                    this.this$1.z().setTranslationX(-width);
                }
            }
        }

        public c() {
        }

        public static final void g(c cVar, AbstractActivityC2019j abstractActivityC2019j) {
            Pair<Integer, Integer> pairA;
            if (!cVar.e().isAttachedToWindow() || (pairA = com.stepos.agentframework.util.G.a(abstractActivityC2019j)) == null) {
                return;
            }
            int iIntValue = pairA.e().intValue();
            int iIntValue2 = pairA.f().intValue();
            NavigationView navigationViewD = cVar.d();
            navigationViewD.setPadding(navigationViewD.getPaddingLeft(), iIntValue, navigationViewD.getPaddingRight(), iIntValue2);
            NavigationView navigationViewD2 = cVar.d();
            ViewGroup.LayoutParams layoutParams = cVar.d().getLayoutParams();
            layoutParams.width = (cVar.e().getWidth() * 2) / 3;
            navigationViewD2.setLayoutParams(layoutParams);
        }

        public final void c() {
            e().h();
        }

        public final NavigationView d() {
            NavigationView navigationView = this.navigationView;
            if (navigationView != null) {
                return navigationView;
            }
            kotlin.jvm.internal.p.A("navigationView");
            return null;
        }

        public final DrawerLayout e() {
            DrawerLayout drawerLayout = this.rootDrawer;
            if (drawerLayout != null) {
                return drawerLayout;
            }
            kotlin.jvm.internal.p.A("rootDrawer");
            return null;
        }

        public final void f(int drawerNavigationLayoutId) {
            View viewFindViewById = AbstractActivityC2019j.this.findViewById(R$id.root);
            kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
            i((DrawerLayout) viewFindViewById);
            e().setScrimColor(0);
            View viewFindViewById2 = AbstractActivityC2019j.this.findViewById(R$id.navigationView);
            kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
            h((NavigationView) viewFindViewById2);
            View viewFindViewById3 = AbstractActivityC2019j.this.findViewById(R$id.mask);
            kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
            this.mask = viewFindViewById3;
            View viewInflate = LayoutInflater.from(e().getContext()).inflate(drawerNavigationLayoutId, d());
            this.navigationContent = viewInflate;
            InterfaceC5074l<View, Y8.t> interfaceC5074lE = AbstractActivityC2019j.this.x().e();
            if (interfaceC5074lE != null) {
                kotlin.jvm.internal.p.f(viewInflate);
                interfaceC5074lE.invoke(viewInflate);
            }
            e().a(new a(AbstractActivityC2019j.this));
            DrawerLayout drawerLayoutE = e();
            final AbstractActivityC2019j abstractActivityC2019j = AbstractActivityC2019j.this;
            drawerLayoutE.post(new Runnable() { // from class: com.stepos.agentframework.chatui.k
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractActivityC2019j.c.g(this.f22975a, abstractActivityC2019j);
                }
            });
        }

        public final void h(NavigationView navigationView) {
            kotlin.jvm.internal.p.i(navigationView, "<set-?>");
            this.navigationView = navigationView;
        }

        public final void i(DrawerLayout drawerLayout) {
            kotlin.jvm.internal.p.i(drawerLayout, "<set-?>");
            this.rootDrawer = drawerLayout;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/j$d", "Lcom/stepos/agentframework/chatui/AgentChatLayout$b;", "", "show", "", "insetBottom", "LY8/t;", Const.INTENT_KEY_APIKEY, "(ZI)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.j$d */
    public static final class d implements AgentChatLayout.InterfaceC1970b {
        public d() {
        }

        @Override // com.stepos.agentframework.chatui.AgentChatLayout.InterfaceC1970b
        public void a(boolean show, int insetBottom) {
            int iA = O6.b.INSTANCE.a(AbstractActivityC2019j.this);
            if (insetBottom <= iA) {
                insetBottom = iA;
            }
            AbstractActivityC2019j.this.C().setPadding(AbstractActivityC2019j.this.C().getPaddingLeft(), AbstractActivityC2019j.this.C().getPaddingTop(), AbstractActivityC2019j.this.C().getPaddingRight(), insetBottom);
        }
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"com/stepos/agentframework/chatui/j$e", "Lcom/stepos/agentframework/chatcore/session/X;", "Lu4/i;", "task", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lu4/i;)V", "", "sessionId", "Lu4/e;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lu4/e;)V", "Lu4/f;", "c", "(Ljava/lang/String;Lu4/f;)V", "Lu4/g;", "e", "(Ljava/lang/String;Lu4/g;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.j$e */
    public static final class e implements com.stepos.agentframework.chatcore.session.X {
        public e() {
        }

        @Override // com.stepos.agentframework.chatcore.session.X
        public void a(AgentTaskPlan task) {
            kotlin.jvm.internal.p.i(task, "task");
            C4148a.k(AbstractActivityC2019j.this.TAG, "TaskCallback onTaskPlan task:" + task, false, 4, null);
            AbstractActivityC2019j.this.W(task);
            AbstractActivityC2019j.this.z().setActionBarSuppressedForTask(true);
        }

        @Override // com.stepos.agentframework.chatcore.session.X
        public /* bridge */ void b(String str, AgentTaskEvent agentTaskEvent) {
            super.b(str, agentTaskEvent);
        }

        @Override // com.stepos.agentframework.chatcore.session.X
        public void c(String sessionId, AgentTaskComplete task) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(task, "task");
            C4148a.k(AbstractActivityC2019j.this.TAG, "TaskCallback onTaskComplete task:" + task + " sessionId:" + sessionId, false, 4, null);
            AbstractActivityC2019j.this.z().setActionBarSuppressedForTask(false);
        }

        @Override // com.stepos.agentframework.chatcore.session.X
        public void d(String sessionId, AgentTask task) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(task, "task");
            C4148a.k(AbstractActivityC2019j.this.TAG, "TaskCallback onTaskExecute task:" + task + " sessionId:" + sessionId, false, 4, null);
            AbstractActivityC2019j.this.X(task);
        }

        @Override // com.stepos.agentframework.chatcore.session.X
        public void e(String sessionId, AgentTaskError task) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(task, "task");
            C4148a.k(AbstractActivityC2019j.this.TAG, "TaskCallback onTaskFailed task:" + task + " sessionId:" + sessionId, false, 4, null);
            AbstractActivityC2019j.this.z().setActionBarSuppressedForTask(false);
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/stepos/agentframework/chatui/j$f", "Lcom/stepos/agentframework/chatui/task/view/TaskPanel$a;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.j$f */
    public static final class f implements TaskPanel.a {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/j$g", "Lcom/stepos/agentframework/chatcore/session/AgentSession$g;", "Lw4/c;", "message", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lw4/c;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.j$g */
    public static final class g implements AgentSession.g {
        @Override // com.stepos.agentframework.chatcore.session.AgentSession.g
        public void a(ChatMessage message) {
            kotlin.jvm.internal.p.i(message, "message");
        }

        @Override // com.stepos.agentframework.chatcore.session.AgentSession.g
        public /* bridge */ void b(boolean z10, Integer num, String str) {
            super.b(z10, num, str);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/agentframework/chatui/j$h", "Lcom/stepos/agentframework/chatcore/session/Z;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.j$h */
    public static final class h implements com.stepos.agentframework.chatcore.session.Z {
        public h() {
        }

        @Override // com.stepos.agentframework.chatcore.session.Z
        public void a() {
            C4148a.k(AbstractActivityC2019j.this.TAG, "conversationCallback onChanged", false, 4, null);
        }
    }

    public static final void K(AbstractActivityC2019j abstractActivityC2019j, View view) {
        abstractActivityC2019j.U();
    }

    public static final Y8.t T(AbstractActivityC2019j abstractActivityC2019j, View it) {
        DrawerLayout drawerLayoutE;
        kotlin.jvm.internal.p.i(it, "it");
        c cVar = abstractActivityC2019j.drawerHelper;
        if (cVar != null && (drawerLayoutE = cVar.e()) != null) {
            drawerLayoutE.K(8388611);
        }
        return Y8.t.f7040a;
    }

    public static final void V(View view) {
        view.setTranslationX(view.getWidth());
        view.animate().translationX(0.0f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }

    private final void v() {
        z().setInsetsListener(new d());
    }

    /* renamed from: A, reason: from getter */
    public final c getDrawerHelper() {
        return this.drawerHelper;
    }

    public final InputLayout B() {
        InputLayout inputLayout = this.inputLayout;
        if (inputLayout != null) {
            return inputLayout;
        }
        kotlin.jvm.internal.p.A("inputLayout");
        return null;
    }

    public final ConstraintLayout C() {
        ConstraintLayout constraintLayout = this.mainLayout;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        kotlin.jvm.internal.p.A("mainLayout");
        return null;
    }

    public final SessionHandler D() {
        SessionHandler sessionHandler = this.sessionHandler;
        if (sessionHandler != null) {
            return sessionHandler;
        }
        kotlin.jvm.internal.p.A("sessionHandler");
        return null;
    }

    public final ImageView E() {
        ImageView imageView = this.taskOnOff;
        if (imageView != null) {
            return imageView;
        }
        kotlin.jvm.internal.p.A("taskOnOff");
        return null;
    }

    public final TaskPanel F() {
        TaskPanel taskPanel = this.taskPanel;
        if (taskPanel != null) {
            return taskPanel;
        }
        kotlin.jvm.internal.p.A("taskPanel");
        return null;
    }

    public final AgentToolBar G() {
        AgentToolBar agentToolBar = this.toolBar;
        if (agentToolBar != null) {
            return agentToolBar;
        }
        kotlin.jvm.internal.p.A("toolBar");
        return null;
    }

    public void H(Configuration configuration, AgentUIConfig appUIConfig) {
        kotlin.jvm.internal.p.i(configuration, "configuration");
        View viewFindViewById = findViewById(R$id.chatLayout);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        M((AgentChatLayout) viewFindViewById);
        z().setAgentUiConfig(appUIConfig);
        z().m3(B());
        z().n3(G());
        z().setLocalFixHostView(y());
        z().k3(D());
        D().N3(new e());
        v();
        w();
    }

    public void I() {
        View viewA;
        if (x().getHasDrawer()) {
            c cVar = new c();
            Integer drawerContentLayoutId = x().getDrawerContentLayoutId();
            kotlin.jvm.internal.p.f(drawerContentLayoutId);
            cVar.f(drawerContentLayoutId.intValue());
            InterfaceC5941c toolBar = z().getToolBar();
            if (toolBar != null && (viewA = toolBar.a(R$id.ivMenu)) != null) {
                setUpDrawerOpenViewClick(viewA);
            }
            this.drawerHelper = cVar;
        }
    }

    public void J() {
    }

    public final void L(LocalAppUIHostView localAppUIHostView) {
        kotlin.jvm.internal.p.i(localAppUIHostView, "<set-?>");
        this.appUIViewHost = localAppUIHostView;
    }

    public final void M(AgentChatLayout agentChatLayout) {
        kotlin.jvm.internal.p.i(agentChatLayout, "<set-?>");
        this.chatLayout = agentChatLayout;
    }

    public final void N(InputLayout inputLayout) {
        kotlin.jvm.internal.p.i(inputLayout, "<set-?>");
        this.inputLayout = inputLayout;
    }

    public final void O(ConstraintLayout constraintLayout) {
        kotlin.jvm.internal.p.i(constraintLayout, "<set-?>");
        this.mainLayout = constraintLayout;
    }

    public final void P(SessionHandler sessionHandler) {
        kotlin.jvm.internal.p.i(sessionHandler, "<set-?>");
        this.sessionHandler = sessionHandler;
    }

    public final void Q(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.taskOnOff = imageView;
    }

    public final void R(TaskPanel taskPanel) {
        kotlin.jvm.internal.p.i(taskPanel, "<set-?>");
        this.taskPanel = taskPanel;
    }

    public final void S(AgentToolBar agentToolBar) {
        kotlin.jvm.internal.p.i(agentToolBar, "<set-?>");
        this.toolBar = agentToolBar;
    }

    public final void U() {
        ExtKt.C(F());
        F().setTranslationX(getResources().getDisplayMetrics().widthPixels);
        slideInFromRight(F());
    }

    public final void W(AgentTaskPlan task) {
        kotlin.jvm.internal.p.i(task, "task");
        C4148a.k("AgentChatBaseActivity", "onTaskPlan", false, 4, null);
        int i10 = getResources().getDisplayMetrics().widthPixels;
        F().getLayoutParams().width = (int) (i10 * 0.75d);
        F().setPanTasks(task);
        ExtKt.C(E());
        E().setTranslationX(i10);
        slideInFromRight(E());
    }

    public final void X(AgentTask task) {
        kotlin.jvm.internal.p.i(task, "task");
        F().c(task);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        kotlin.jvm.internal.p.h(intent, "getIntent(...)");
        Configuration configurationB = (Configuration) intent.getSerializableExtra("agent_configuration", Configuration.class);
        if (configurationB == null) {
            configurationB = Configuration.INSTANCE.a("").b();
        }
        if (getIntent().getBooleanExtra("extra_force_new_session", false)) {
            configurationB.getSessionConfig().C(true);
            configurationB.getSessionConfig().A("");
        }
        Intent intent2 = getIntent();
        kotlin.jvm.internal.p.h(intent2, "getIntent(...)");
        AgentUIConfig agentUIConfig = (AgentUIConfig) intent2.getSerializableExtra("agent_ui_config", AgentUIConfig.class);
        P(new SessionHandler(configurationB));
        super.setContentView(x().getMainLayoutId());
        View viewFindViewById = findViewById(R$id.main_layout);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        O((ConstraintLayout) viewFindViewById);
        View viewFindViewById2 = findViewById(R$id.app_ui_host_view);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        L((LocalAppUIHostView) viewFindViewById2);
        View viewFindViewById3 = findViewById(R$id.task_on_off);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        Q((ImageView) viewFindViewById3);
        View viewFindViewById4 = findViewById(R$id.task_panel);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        R((TaskPanel) viewFindViewById4);
        E().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbstractActivityC2019j.K(this.f22945a, view);
            }
        });
        F().setListener(new f());
        D().L3(new g());
        D().G3(new h());
        View viewFindViewById5 = findViewById(R$id.my_input_layout);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        N((InputLayout) viewFindViewById5);
        View viewFindViewById6 = findViewById(R$id.agent_tool_bar);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        S((AgentToolBar) viewFindViewById6);
        H(configurationB, agentUIConfig);
        I();
        J();
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        z().X5();
        D().d3();
    }

    @Override // b.q, android.app.Activity
    public void onNewIntent(Intent intent) {
        kotlin.jvm.internal.p.i(intent, "intent");
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent.getBooleanExtra("extra_force_new_session", false)) {
            C4148a.k(this.TAG, "onNewIntent: force new session", false, 4, null);
            if (this.chatLayout != null) {
                AgentChatLayout.K3(z(), false, null, null, 6, null);
            }
        }
    }

    @Override // androidx.appcompat.app.d, b.q, android.app.Activity
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
    }

    public void setUpDrawerOpenViewClick(View openClickView) {
        kotlin.jvm.internal.p.i(openClickView, "openClickView");
        if (x().getHasDrawer()) {
            C2154c.b(openClickView, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.g
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AbstractActivityC2019j.T(this.f22963a, (View) obj);
                }
            });
        }
    }

    public final void slideInFromRight(final View view) {
        kotlin.jvm.internal.p.i(view, "view");
        view.post(new Runnable() { // from class: com.stepos.agentframework.chatui.f
            @Override // java.lang.Runnable
            public final void run() {
                AbstractActivityC2019j.V(view);
            }
        });
    }

    public final void w() {
        ViewGroup.LayoutParams layoutParams = C().getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        O6.b bVar = O6.b.INSTANCE;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) (bVar.b(this) * 0.9f);
        if (bVar.c(this)) {
            C().setPadding(C().getPaddingLeft(), C().getPaddingTop(), C().getPaddingRight(), bVar.a(this));
        }
    }

    public abstract AgentChatConfig x();

    public final LocalAppUIHostView y() {
        LocalAppUIHostView localAppUIHostView = this.appUIViewHost;
        if (localAppUIHostView != null) {
            return localAppUIHostView;
        }
        kotlin.jvm.internal.p.A("appUIViewHost");
        return null;
    }

    public final AgentChatLayout z() {
        AgentChatLayout agentChatLayout = this.chatLayout;
        if (agentChatLayout != null) {
            return agentChatLayout;
        }
        kotlin.jvm.internal.p.A("chatLayout");
        return null;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR%\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010#\u001a\u0004\b$\u0010%R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b&\u0010%¨\u0006'"}, d2 = {"Lcom/stepos/agentframework/chatui/j$a;", "", "", "mainLayoutId", "", "hasDrawer", "drawerContentLayoutId", "Lkotlin/Function1;", "Landroid/view/View;", "LY8/t;", "drawerContentInitializer", "Lkotlin/Function0;", "onDrawerOpened", "onDrawerClosed", "<init>", "(IZLjava/lang/Integer;Lp9/l;Lp9/a;Lp9/a;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Z", "Ljava/lang/Integer;", "f", "()Ljava/lang/Integer;", "Lp9/l;", "e", "()Lp9/l;", "Lp9/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lp9/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.j$a, reason: from toString */
    public static final /* data */ class AgentChatConfig {
        private final InterfaceC5074l<View, Y8.t> drawerContentInitializer;
        private final Integer drawerContentLayoutId;
        private final boolean hasDrawer;
        private final int mainLayoutId;
        private final InterfaceC5063a<Y8.t> onDrawerClosed;
        private final InterfaceC5063a<Y8.t> onDrawerOpened;

        /* JADX WARN: Multi-variable type inference failed */
        public AgentChatConfig(int i10, boolean z10, Integer num, InterfaceC5074l<? super View, Y8.t> interfaceC5074l, InterfaceC5063a<Y8.t> onDrawerOpened, InterfaceC5063a<Y8.t> onDrawerClosed) {
            kotlin.jvm.internal.p.i(onDrawerOpened, "onDrawerOpened");
            kotlin.jvm.internal.p.i(onDrawerClosed, "onDrawerClosed");
            this.mainLayoutId = i10;
            this.hasDrawer = z10;
            this.drawerContentLayoutId = num;
            this.drawerContentInitializer = interfaceC5074l;
            this.onDrawerOpened = onDrawerOpened;
            this.onDrawerClosed = onDrawerClosed;
        }

        public static final Y8.t c() {
            return Y8.t.f7040a;
        }

        public static final Y8.t d() {
            return Y8.t.f7040a;
        }

        public final InterfaceC5074l<View, Y8.t> e() {
            return this.drawerContentInitializer;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AgentChatConfig)) {
                return false;
            }
            AgentChatConfig agentChatConfig = (AgentChatConfig) other;
            return this.mainLayoutId == agentChatConfig.mainLayoutId && this.hasDrawer == agentChatConfig.hasDrawer && kotlin.jvm.internal.p.d(this.drawerContentLayoutId, agentChatConfig.drawerContentLayoutId) && kotlin.jvm.internal.p.d(this.drawerContentInitializer, agentChatConfig.drawerContentInitializer) && kotlin.jvm.internal.p.d(this.onDrawerOpened, agentChatConfig.onDrawerOpened) && kotlin.jvm.internal.p.d(this.onDrawerClosed, agentChatConfig.onDrawerClosed);
        }

        /* renamed from: f, reason: from getter */
        public final Integer getDrawerContentLayoutId() {
            return this.drawerContentLayoutId;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getHasDrawer() {
            return this.hasDrawer;
        }

        /* renamed from: h, reason: from getter */
        public final int getMainLayoutId() {
            return this.mainLayoutId;
        }

        public int hashCode() {
            int iHashCode = ((Integer.hashCode(this.mainLayoutId) * 31) + Boolean.hashCode(this.hasDrawer)) * 31;
            Integer num = this.drawerContentLayoutId;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            InterfaceC5074l<View, Y8.t> interfaceC5074l = this.drawerContentInitializer;
            return ((((iHashCode2 + (interfaceC5074l != null ? interfaceC5074l.hashCode() : 0)) * 31) + this.onDrawerOpened.hashCode()) * 31) + this.onDrawerClosed.hashCode();
        }

        public final InterfaceC5063a<Y8.t> i() {
            return this.onDrawerClosed;
        }

        public final InterfaceC5063a<Y8.t> j() {
            return this.onDrawerOpened;
        }

        public String toString() {
            return "AgentChatConfig(mainLayoutId=" + this.mainLayoutId + ", hasDrawer=" + this.hasDrawer + ", drawerContentLayoutId=" + this.drawerContentLayoutId + ", drawerContentInitializer=" + this.drawerContentInitializer + ", onDrawerOpened=" + this.onDrawerOpened + ", onDrawerClosed=" + this.onDrawerClosed + ")";
        }

        public /* synthetic */ AgentChatConfig(int i10, boolean z10, Integer num, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, int i11, kotlin.jvm.internal.i iVar) {
            this(i10, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? 0 : num, (i11 & 8) != 0 ? null : interfaceC5074l, (i11 & 16) != 0 ? new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.h
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AbstractActivityC2019j.AgentChatConfig.c();
                }
            } : interfaceC5063a, (i11 & 32) != 0 ? new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.i
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return AbstractActivityC2019j.AgentChatConfig.d();
                }
            } : interfaceC5063a2);
        }
    }
}
