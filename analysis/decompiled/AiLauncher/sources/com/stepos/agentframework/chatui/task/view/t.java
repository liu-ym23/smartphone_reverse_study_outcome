package com.stepos.agentframework.chatui.task.view;

import La.H;
import Z8.F;
import android.R;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.I;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$color;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$menu;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.DisplayTool;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.uikit.M;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a\u0019\u0010\r\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001aI\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00192\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001ai\u0010#\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u001c\b\u0002\u0010!\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010\u001e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\t0\u001eH\u0002¢\u0006\u0004\b#\u0010$\u001aA\u0010*\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b*\u0010+\u001aA\u0010,\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b,\u0010+\u001a\u0017\u0010-\u001a\u00020\u00052\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b-\u0010.\u001aA\u0010/\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b/\u0010+\u001a%\u00103\u001a\u00020\t2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0005¢\u0006\u0004\b3\u00104\u001a\u0017\u00106\u001a\u0002052\u0006\u00100\u001a\u00020(H\u0002¢\u0006\u0004\b6\u00107\u001a\u001f\u00108\u001a\u0002052\u0006\u00100\u001a\u00020(2\u0006\u00102\u001a\u00020\u0005H\u0002¢\u0006\u0004\b8\u00109\u001a\u0019\u0010<\u001a\u00020\u0016*\u00020\u00132\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=\"\u0014\u0010>\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u0010?\"\u0014\u0010@\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u0010?\"\u0014\u0010B\u001a\u00020A8\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006D"}, d2 = {"Landroid/view/View;", "view", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/view/View;)Lcom/stepos/agentframework/chatui/AgentChatLayout;", "", "O", "(Landroid/view/View;)Z", "Lkotlin/Function0;", "LY8/t;", "onReady", "t", "(Landroid/view/View;Lp9/a;)V", "B", "(Landroid/view/View;)Landroid/view/View;", "original", "Landroid/graphics/Rect;", "u", "(Landroid/view/View;)Landroid/graphics/Rect;", "", "rawX", "rawY", "", "popupWidthPx", "popupHeightPx", "Lkotlin/Pair;", "v", "(Landroid/view/View;FFII)Lkotlin/Pair;", "menuRes", "widthPx", "Lkotlin/Function1;", "", "Landroid/view/MenuItem;", "customizeItems", "onItemClick", ExifInterface.GPS_DIRECTION_TRUE, "(Landroid/view/View;FFIILp9/l;Lp9/l;)V", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "position", "Lcom/stepos/agentframework/chatui/N1;", "message", "G", "(Landroid/view/View;FFLcom/stepos/agentframework/chatui/U1;ILcom/stepos/agentframework/chatui/N1;)V", "C", "P", "(Lcom/stepos/agentframework/chatui/N1;)Z", "M", "item", LinkHeader.Parameters.Anchor, "stripMarkdown", "y", "(Lcom/stepos/agentframework/chatui/N1;Landroid/view/View;Z)V", "", "Q", "(Lcom/stepos/agentframework/chatui/N1;)Ljava/lang/String;", ExifInterface.LATITUDE_SOUTH, "(Lcom/stepos/agentframework/chatui/N1;Z)Ljava/lang/String;", "Landroid/content/Context;", "context", "z", "(FLandroid/content/Context;)I", "CHAT_POPUP_MENU_WIDTH_DP", "F", "CHAT_POPUP_SAFE_MARGIN_DP", "", "POPUP_SETTLE_TIMEOUT_MS", "J", "agentcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class t {
    private static final float CHAT_POPUP_MENU_WIDTH_DP = 136.0f;
    private static final float CHAT_POPUP_SAFE_MARGIN_DP = 10.0f;
    private static final long POPUP_SETTLE_TIMEOUT_MS = 500;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/stepos/agentframework/chatui/task/view/t$a", "Ljava/lang/Runnable;", "LY8/t;", "run", "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Runnable {
        final /* synthetic */ Ref$IntRef $lastY;
        final /* synthetic */ InterfaceC5063a<Y8.t> $onReady;
        final /* synthetic */ Ref$IntRef $stableFrames;
        final /* synthetic */ long $start;
        final /* synthetic */ View $view;

        public a(long j10, InterfaceC5063a<Y8.t> interfaceC5063a, View view, Ref$IntRef ref$IntRef, Ref$IntRef ref$IntRef2) {
            this.$start = j10;
            this.$onReady = interfaceC5063a;
            this.$view = view;
            this.$stableFrames = ref$IntRef;
            this.$lastY = ref$IntRef2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SystemClock.uptimeMillis() - this.$start >= 500) {
                this.$onReady.invoke();
                return;
            }
            if (t.O(this.$view)) {
                this.$stableFrames.f34818a = 0;
                this.$lastY.f34818a = Integer.MIN_VALUE;
                this.$view.postOnAnimation(this);
                return;
            }
            int[] iArr = new int[2];
            this.$view.getLocationOnScreen(iArr);
            int i10 = iArr[1];
            Ref$IntRef ref$IntRef = this.$lastY;
            if (i10 == ref$IntRef.f34818a) {
                this.$stableFrames.f34818a++;
            } else {
                this.$stableFrames.f34818a = 0;
                ref$IntRef.f34818a = i10;
            }
            if (this.$stableFrames.f34818a >= 2) {
                this.$onReady.invoke();
            } else {
                this.$view.postOnAnimation(this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/chatui/task/view/t$b", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "LY8/t;", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements View.OnAttachStateChangeListener {
        final /* synthetic */ Ref$ObjectRef<y7.E> $glassHandle;

        public b(Ref$ObjectRef<y7.E> ref$ObjectRef) {
            this.$glassHandle = ref$ObjectRef;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View v10) {
            kotlin.jvm.internal.p.i(v10, "v");
            y7.E e10 = this.$glassHandle.f34820a;
            if (e10 != null) {
                e10.g();
            }
            this.$glassHandle.f34820a = null;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatui/task/view/t$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "LY8/t;", "getOutline", "(Landroid/view/View;Landroid/graphics/Outline;)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ViewOutlineProvider {
        final /* synthetic */ float $cornerPx;

        public c(float f10) {
            this.$cornerPx = f10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$cornerPx);
        }
    }

    public static final AgentChatLayout A(View view) {
        while (view != null) {
            if (view instanceof AgentChatLayout) {
                return (AgentChatLayout) view;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static final View B(View view) {
        View view2 = null;
        while (view != null) {
            if (view instanceof AgentChatLayout) {
                return view;
            }
            Object parent = view.getParent();
            View view3 = parent instanceof View ? (View) parent : null;
            view2 = view;
            view = view3;
        }
        return view2;
    }

    public static final void C(final View view, float f10, float f11, final U1 u12, final int i10, final DisplayMessage displayMessage) {
        final Context context = view.getContext();
        if (P(displayMessage)) {
            M(view, f10, f11, u12, i10, displayMessage);
            return;
        }
        int i11 = R$menu.chat_pop_menu_sys;
        kotlin.jvm.internal.p.f(context);
        T(view, f10, f11, i11, z(CHAT_POPUP_MENU_WIDTH_DP, context), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.D(displayMessage, context, (List) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.k
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.F(u12, i10, displayMessage, view, ((Integer) obj).intValue());
            }
        });
    }

    public static final Y8.t D(DisplayMessage displayMessage, Context context, List items) {
        Drawable drawableMutate;
        kotlin.jvm.internal.p.i(items, "items");
        if (S(displayMessage, true).length() == 0) {
            Z8.A.L(items, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.q
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(t.E((MenuItem) obj));
                }
            });
        }
        kotlin.jvm.internal.p.f(context);
        int iZ = z(16.0f, context);
        Iterator it = items.iterator();
        while (it.hasNext()) {
            MenuItem menuItem = (MenuItem) it.next();
            int itemId = menuItem.getItemId();
            if (itemId == R$id.menu_like) {
                Drawable drawable = context.getDrawable(displayMessage.getLikeStatus() == 1 ? R$drawable.ic_action_liked_fill : R$drawable.ic_action_like);
                drawableMutate = drawable != null ? drawable.mutate() : null;
                if (displayMessage.getLikeStatus() != 1 && drawableMutate != null) {
                    drawableMutate.setTint(context.getColor(R$color.chat_popup_icon_default));
                }
                if (drawableMutate != null) {
                    drawableMutate.setBounds(0, 0, iZ, iZ);
                }
                menuItem.setIcon(drawableMutate);
            } else if (itemId == R$id.menu_unlike) {
                Drawable drawable2 = context.getDrawable(displayMessage.getLikeStatus() == 2 ? R$drawable.ic_action_disliked_fill : R$drawable.ic_popup_dislike);
                drawableMutate = drawable2 != null ? drawable2.mutate() : null;
                if (displayMessage.getLikeStatus() != 2 && drawableMutate != null) {
                    drawableMutate.setTint(context.getColor(R$color.chat_popup_icon_default));
                }
                if (drawableMutate != null) {
                    drawableMutate.setBounds(0, 0, iZ, iZ);
                }
                menuItem.setIcon(drawableMutate);
            }
        }
        return Y8.t.f7040a;
    }

    public static final boolean E(MenuItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getItemId() == R$id.menu_select_txt;
    }

    public static final Y8.t F(U1 u12, int i10, DisplayMessage displayMessage, View view, int i11) {
        if (i11 == R$id.menu_copy) {
            if (u12 != null) {
                u12.z(i10, displayMessage);
            }
        } else if (i11 == R$id.menu_select_txt) {
            y(displayMessage, view, true);
        } else if (i11 == R$id.menu_delete) {
            if (u12 != null) {
                u12.t(i10, displayMessage);
            }
        } else if (i11 == R$id.menu_like) {
            if (u12 != null) {
                u12.i(i10, displayMessage);
            }
        } else if (i11 == R$id.menu_unlike && u12 != null) {
            u12.D(i10, displayMessage);
        }
        return Y8.t.f7040a;
    }

    public static final void G(final View view, float f10, float f11, final U1 u12, final int i10, final DisplayMessage displayMessage) {
        int i11 = R$menu.chat_pop_menu_user;
        Context context = view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        T(view, f10, f11, i11, z(CHAT_POPUP_MENU_WIDTH_DP, context), new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.l
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.H(displayMessage, u12, (List) obj);
            }
        }, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.m
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.K(u12, i10, displayMessage, view, ((Integer) obj).intValue());
            }
        });
    }

    public static final Y8.t H(DisplayMessage displayMessage, U1 u12, List items) {
        AgentUIConfig agentUiConfig;
        final Set<Integer> setB;
        kotlin.jvm.internal.p.i(items, "items");
        if (Q(displayMessage).length() == 0) {
            Z8.A.L(items, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.o
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(t.I((MenuItem) obj));
                }
            });
        }
        if (u12 != null && (agentUiConfig = u12.getAgentUiConfig()) != null && (setB = agentUiConfig.b()) != null && !setB.isEmpty()) {
            Z8.A.L(items, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.p
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(t.J(setB, (MenuItem) obj));
                }
            });
        }
        return Y8.t.f7040a;
    }

    public static final boolean I(MenuItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getItemId() == R$id.menu_select_txt;
    }

    public static final boolean J(Set set, MenuItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        return set.contains(Integer.valueOf(it.getItemId()));
    }

    public static final Y8.t K(U1 u12, int i10, final DisplayMessage displayMessage, View view, int i11) {
        if (i11 == R$id.menu_copy) {
            if (u12 != null) {
                u12.z(i10, displayMessage);
            }
        } else if (i11 == R$id.menu_select_txt) {
            y(displayMessage, view, false);
        } else if (i11 == R$id.menu_delete) {
            if (u12 != null) {
                u12.t(i10, displayMessage);
            }
        } else if (i11 == R$id.menu_edit && u12 != null) {
            List<DisplayChatMessage> listM = displayMessage.m();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listM) {
                if (((DisplayChatMessage) obj).getType() == AgentMessageType.TEXT) {
                    arrayList.add(obj);
                }
            }
            u12.setInputLayoutText(F.A0(arrayList, null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.h
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj2) {
                    return t.L(displayMessage, (DisplayChatMessage) obj2);
                }
            }, 31, null));
        }
        return Y8.t.f7040a;
    }

    public static final CharSequence L(DisplayMessage displayMessage, DisplayChatMessage it) {
        String strH;
        kotlin.jvm.internal.p.i(it, "it");
        com.stepos.agentframework.chatui.util.a aVar = com.stepos.agentframework.chatui.util.a.INSTANCE;
        String agentId = displayMessage.getAgentId();
        com.stepos.agentframework.chatui.util.r rVar = com.stepos.agentframework.chatui.util.r.INSTANCE;
        O6.f fVar = O6.f.INSTANCE;
        u4.m content = it.getContent();
        if (content == null || (strH = content.h()) == null) {
            strH = "";
        }
        return aVar.a(agentId, rVar.a(fVar.b(strH)));
    }

    public static final void M(View view, float f10, float f11, final U1 u12, final int i10, final DisplayMessage displayMessage) {
        int i11 = R$menu.chat_pop_menu_widget;
        Context context = view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        U(view, f10, f11, i11, z(CHAT_POPUP_MENU_WIDTH_DP, context), null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return t.N(u12, i10, displayMessage, ((Integer) obj).intValue());
            }
        }, 32, null);
    }

    public static final Y8.t N(U1 u12, int i10, DisplayMessage displayMessage, int i11) {
        if (i11 == R$id.menu_delete) {
            if (u12 != null) {
                u12.t(i10, displayMessage);
            }
        } else if (i11 == R$id.menu_feedback && u12 != null) {
            u12.D(i10, displayMessage);
        }
        return Y8.t.f7040a;
    }

    public static final boolean O(View view) {
        AgentChatLayout agentChatLayoutA = A(view);
        if (agentChatLayoutA != null) {
            return agentChatLayoutA.getIsKeyboardVisible();
        }
        a0 a0VarB = N.B(view);
        if (a0VarB != null) {
            return a0VarB.r(a0.o.b());
        }
        return false;
    }

    public static final boolean P(DisplayMessage displayMessage) {
        List<DisplayChatMessage> listM = displayMessage.m();
        if ((listM instanceof Collection) && listM.isEmpty()) {
            return false;
        }
        Iterator<T> it = listM.iterator();
        while (it.hasNext()) {
            List<DisplayTool> listF = ((DisplayChatMessage) it.next()).f();
            if (listF != null) {
                List<DisplayTool> list = listF;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        AppUIData appUIData = ((DisplayTool) it2.next()).getAppUIData();
                        if (appUIData != null && appUIData.getUiType() == AppUIData.INSTANCE.e()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final String Q(final DisplayMessage displayMessage) {
        List<DisplayChatMessage> listM = displayMessage.m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (((DisplayChatMessage) obj).getType() == AgentMessageType.TEXT) {
                arrayList.add(obj);
            }
        }
        return H.D1(F.A0(arrayList, "\n", null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.agentframework.chatui.task.view.n
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj2) {
                return t.R(displayMessage, (DisplayChatMessage) obj2);
            }
        }, 30, null)).toString();
    }

    public static final CharSequence R(DisplayMessage displayMessage, DisplayChatMessage it) {
        String strH;
        kotlin.jvm.internal.p.i(it, "it");
        com.stepos.agentframework.chatui.util.a aVar = com.stepos.agentframework.chatui.util.a.INSTANCE;
        String agentId = displayMessage.getAgentId();
        com.stepos.agentframework.chatui.util.r rVar = com.stepos.agentframework.chatui.util.r.INSTANCE;
        O6.f fVar = O6.f.INSTANCE;
        u4.m content = it.getContent();
        if (content == null || (strH = content.h()) == null) {
            strH = "";
        }
        return aVar.a(agentId, rVar.a(fVar.b(strH)));
    }

    public static final String S(DisplayMessage displayMessage, boolean z10) {
        String strQ = Q(displayMessage);
        return z10 ? M.c(strQ) : strQ;
    }

    public static final void T(View view, float f10, float f11, int i10, int i11, InterfaceC5074l<? super List<MenuItem>, Y8.t> interfaceC5074l, final InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l2) {
        Context context = view.getContext();
        I i12 = new I(context, view);
        i12.b().inflate(i10, i12.a());
        ArrayList<MenuItem> arrayList = new ArrayList(i12.a().size());
        int size = i12.a().size();
        for (int i13 = 0; i13 < size; i13++) {
            MenuItem item = i12.a().getItem(i13);
            if (item.isVisible()) {
                arrayList.add(item);
            }
        }
        kotlin.jvm.internal.p.f(context);
        int iZ = z(16.0f, context);
        for (MenuItem menuItem : arrayList) {
            Drawable icon = menuItem.getIcon();
            if (icon != null) {
                Drawable drawableMutate = icon.mutate();
                kotlin.jvm.internal.p.h(drawableMutate, "mutate(...)");
                drawableMutate.setBounds(0, 0, iZ, iZ);
                menuItem.setIcon(drawableMutate);
            }
        }
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(arrayList);
        }
        int iZ2 = z(14.0f, context);
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(androidx.core.content.a.e(context, R$drawable.bg_chat_pop_menu));
        linearLayout.setPadding(0, iZ2, 0, iZ2);
        linearLayout.setClipToPadding(true);
        final float f12 = 12.0f;
        float f13 = linearLayout.getResources().getDisplayMetrics().density * 12.0f;
        linearLayout.setClipToOutline(true);
        linearLayout.setOutlineProvider(new c(f13));
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final PopupWindow popupWindow = new PopupWindow((View) linearLayout, i11, -2, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        for (MenuItem menuItem2 : arrayList) {
            View viewInflate = layoutInflaterFrom.inflate(R$layout.item_chat_pop_menu, (ViewGroup) linearLayout, false);
            viewInflate.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            ((ImageView) viewInflate.findViewById(R$id.icon)).setImageDrawable(menuItem2.getIcon());
            ((TextView) viewInflate.findViewById(R$id.title)).setText(menuItem2.getTitle());
            final int itemId = menuItem2.getItemId();
            final CharSequence title = menuItem2.getTitle();
            viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.task.view.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    t.V(itemId, title, popupWindow, interfaceC5074l2, view2);
                }
            });
            linearLayout.addView(viewInflate);
        }
        linearLayout.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Pair<View, InterfaceC5063a<Y8.t>> pairV = v(view, f10, f11, i11, linearLayout.getMeasuredHeight());
        View viewA = pairV.a();
        final InterfaceC5063a<Y8.t> interfaceC5063aB = pairV.b();
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.stepos.agentframework.chatui.task.view.s
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                t.W(popupWindow, ref$ObjectRef, interfaceC5063aB);
            }
        });
        linearLayout.addOnAttachStateChangeListener(new b(ref$ObjectRef));
        popupWindow.showAsDropDown(viewA, 0, 0, 0);
        B b10 = B.INSTANCE;
        View rootView = view.getRootView();
        kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
        b10.j(popupWindow, rootView);
        linearLayout.post(new Runnable() { // from class: com.stepos.agentframework.chatui.task.view.f
            @Override // java.lang.Runnable
            public final void run() {
                t.X(popupWindow, ref$ObjectRef, linearLayout, f12);
            }
        });
    }

    public static /* synthetic */ void U(View view, float f10, float f11, int i10, int i11, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, int i12, Object obj) {
        if ((i12 & 32) != 0) {
            interfaceC5074l = null;
        }
        T(view, f10, f11, i10, i11, interfaceC5074l, interfaceC5074l2);
    }

    public static final void V(int i10, CharSequence charSequence, PopupWindow popupWindow, InterfaceC5074l interfaceC5074l, View view) {
        C4148a.d("ChatPopMenuView", "onItemClick id=" + i10 + " title=" + ((Object) charSequence), false, 4, null);
        popupWindow.dismiss();
        interfaceC5074l.invoke(Integer.valueOf(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void W(PopupWindow popupWindow, Ref$ObjectRef ref$ObjectRef, InterfaceC5063a interfaceC5063a) {
        B.INSTANCE.p(popupWindow);
        y7.E e10 = (y7.E) ref$ObjectRef.f34820a;
        if (e10 != null) {
            e10.g();
        }
        ref$ObjectRef.f34820a = null;
        interfaceC5063a.invoke();
    }

    /* JADX WARN: Type inference failed for: r4v7, types: [T, y7.E] */
    public static final void X(PopupWindow popupWindow, Ref$ObjectRef ref$ObjectRef, LinearLayout linearLayout, float f10) {
        if (popupWindow.isShowing() && ref$ObjectRef.f34820a == 0) {
            y7.B bI = y7.H.a(s7.p.f40121a, linearLayout).x(true).i(y7.o.INSTANCE.h());
            bI.w(f10 * linearLayout.getResources().getDisplayMetrics().density);
            ?? U10 = bI.u();
            if (U10.c() == 0) {
                C4148a.k("ChatPopMenuView", "glass fully degraded, fallback to bg_chat_pop_menu", false, 4, null);
                U10.g();
                ref$ObjectRef.f34820a = null;
                return;
            }
            ref$ObjectRef.f34820a = U10;
            C4148a.d("ChatPopMenuView", "glass attached activeCount=" + U10.c() + " ids=" + U10.d(), false, 4, null);
        }
    }

    public static final void t(View view, InterfaceC5063a<Y8.t> interfaceC5063a) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.f34818a = Integer.MIN_VALUE;
        view.postOnAnimation(new a(jUptimeMillis, interfaceC5063a, view, new Ref$IntRef(), ref$IntRef));
    }

    public static final Rect u(View view) {
        Rect rect = new Rect();
        View viewB = B(view);
        if (viewB == null || viewB.getWidth() <= 0 || viewB.getHeight() <= 0) {
            view.getRootView().getWindowVisibleDisplayFrame(rect);
            return rect;
        }
        int[] iArr = new int[2];
        viewB.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        rect.set(i10, iArr[1], viewB.getWidth() + i10, iArr[1] + viewB.getHeight());
        Rect rect2 = new Rect();
        view.getRootView().getWindowVisibleDisplayFrame(rect2);
        if (!rect.intersect(rect2)) {
            rect.set(rect2);
        }
        return rect;
    }

    public static final Pair<View, InterfaceC5063a<Y8.t>> v(View view, float f10, float f11, int i10, int i11) {
        ViewGroup viewGroup = (ViewGroup) view.getRootView().findViewById(R.id.content);
        if (viewGroup == null) {
            return Y8.j.a(view, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.task.view.i
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return t.w();
                }
            });
        }
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        Rect rectU = u(view);
        Context context = view.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        int iZ = z(10.0f, context);
        int i12 = rectU.left + iZ;
        int iN = C5685n.n(((int) f10) - (i10 / 2), i12, C5685n.f((rectU.right - i10) - iZ, i12));
        int i13 = rectU.top + iZ;
        int iN2 = C5685n.n(((int) f11) - (i11 / 2), i13, C5685n.f((rectU.bottom - i11) - iZ, i13));
        int iF = C5685n.f(iN - iArr[0], 0);
        int iF2 = C5685n.f(iN2 - iArr[1], 0);
        final View view2 = new View(view.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
        layoutParams.gravity = 8388659;
        layoutParams.leftMargin = iF;
        layoutParams.topMargin = iF2;
        view2.setLayoutParams(layoutParams);
        viewGroup.addView(view2);
        return Y8.j.a(view2, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.task.view.j
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return t.x(view2);
            }
        });
    }

    public static final Y8.t w() {
        return Y8.t.f7040a;
    }

    public static final Y8.t x(View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        return Y8.t.f7040a;
    }

    public static final void y(DisplayMessage item, View anchor, boolean z10) {
        kotlin.jvm.internal.p.i(item, "item");
        kotlin.jvm.internal.p.i(anchor, "anchor");
        String strS = S(item, z10);
        if (strS.length() == 0) {
            C4148a.u("ChatPopMenuView", "doSelectTxtAction: no text content", false, 4, null);
            return;
        }
        Context context = anchor.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        new com.stepos.agentframework.chatui.dialog.N(context, strS, anchor.getRootView()).show();
    }

    public static final int z(float f10, Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }
}
