package com.stepos.agentframework.chatui.task.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.task.view.C2054d;
import com.stepos.agentframework.chatui.view.MessageContentContainer;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/agentframework/chatui/task/view/d;", "", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.task.view.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2054d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int TYPE_TXT_SYS = 2;
    public static final int TYPE_TXT_USER = 1;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J;\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatui/task/view/d$a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_UMID, "Landroid/view/View;", "view", "", "type", "Lcom/stepos/agentframework/chatui/N1;", "message", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "position", "e", "(Landroid/view/View;ILcom/stepos/agentframework/chatui/N1;Lcom/stepos/agentframework/chatui/U1;I)V", "TYPE_TXT_USER", "I", "TYPE_TXT_SYS", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.task.view.d$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static /* synthetic */ void f(Companion companion, View view, int i10, DisplayMessage displayMessage, U1 u12, int i11, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                u12 = null;
            }
            U1 u13 = u12;
            if ((i12 & 16) != 0) {
                i11 = 0;
            }
            companion.e(view, i10, displayMessage, u13, i11);
        }

        public static final boolean g(View view, float[] fArr, View view2, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() == 0) {
                view.getLocationOnScreen(new int[2]);
                fArr[0] = motionEvent.getRawX() - r4[0];
                fArr[1] = motionEvent.getRawY() - r4[1];
            }
            return false;
        }

        public static final boolean h(final View view, final float[] fArr, final int i10, final U1 u12, final int i11, final DisplayMessage displayMessage, View view2) {
            C4148a.d("ChatPopMenuView", "registerPressListener", false, 4, null);
            InterfaceC5063a interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.task.view.c
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C2054d.Companion.i(view, fArr, i10, u12, i11, displayMessage);
                }
            };
            if (!t.O(view)) {
                interfaceC5063a.invoke();
                return true;
            }
            com.stepos.agentframework.util.A a10 = com.stepos.agentframework.util.A.INSTANCE;
            Context context = view.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            a10.a(context, view);
            t.t(view, interfaceC5063a);
            return true;
        }

        public static final Y8.t i(View view, float[] fArr, int i10, U1 u12, int i11, DisplayMessage displayMessage) {
            Pair<Float, Float> pairA;
            if (view instanceof MessageContentContainer) {
                pairA = ((MessageContentContainer) view).Q();
            } else {
                view.getLocationOnScreen(new int[2]);
                pairA = Y8.j.a(Float.valueOf(r0[0] + fArr[0]), Float.valueOf(r0[1] + fArr[1]));
            }
            float fFloatValue = pairA.a().floatValue();
            float fFloatValue2 = pairA.b().floatValue();
            if (i10 == 1) {
                t.G(view, fFloatValue, fFloatValue2, u12, i11, displayMessage);
            } else if (i10 == 2) {
                t.C(view, fFloatValue, fFloatValue2, u12, i11, displayMessage);
            }
            return Y8.t.f7040a;
        }

        public final void d() {
            B.h(null);
        }

        public final void e(final View view, final int type, final DisplayMessage message, final U1 chatView, final int position) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(message, "message");
            final float[] fArr = {0.0f, 0.0f};
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.agentframework.chatui.task.view.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    return C2054d.Companion.g(view, fArr, view2, motionEvent);
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.stepos.agentframework.chatui.task.view.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    return C2054d.Companion.h(view, fArr, type, chatView, position, message, view2);
                }
            });
        }

        public Companion() {
        }
    }
}
