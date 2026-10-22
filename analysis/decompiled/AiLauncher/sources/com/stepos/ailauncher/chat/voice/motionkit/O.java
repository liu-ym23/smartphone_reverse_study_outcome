package com.stepos.ailauncher.chat.voice.motionkit;

import Z8.C1174w;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import s7.EffectDefinition;
import s7.w;
import v9.C5685n;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\t\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0018\u001a\u00020\u0012*\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019\u001a)\u0010\u001d\u001a\u00020\u001a*\u00020\u001a2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001bH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u001b2\u0006\u0010\u001f\u001a\u00020\u001aH\u0000¢\u0006\u0004\b \u0010!\"\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/q;", "bag", "", "m", "(Lcom/stepos/ailauncher/chat/voice/motionkit/q;)F", "", "name", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Ljava/lang/String;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Z", "Landroid/widget/FrameLayout;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Landroid/widget/PopupWindow;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/widget/FrameLayout;)Landroid/widget/PopupWindow;", "popup", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/widget/PopupWindow;)V", "Ls7/k;", "", "v", "k", "(Ls7/k;Ljava/lang/String;[F)V", "Ls7/e;", "", "vals", "n", "(Ls7/e;Ljava/util/Map;)Ls7/e;", "def", "l", "(Ls7/e;)Ljava/util/Map;", "WATER_DESIGN_TOTAL", "F", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class O {
    private static final float WATER_DESIGN_TOTAL = 1.767f;

    public static final boolean g(String str) {
        return str.length() > 2 && La.D.X(str, "uR", false, 2, null) && Character.isUpperCase(str.charAt(2));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0015, code lost:
    
        r2 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(android.widget.PopupWindow r2) {
        /*
            android.view.View r2 = r2.getContentView()
            r0 = 0
            if (r2 == 0) goto Lc
            android.view.ViewParent r2 = r2.getParent()
            goto Ld
        Lc:
            r2 = r0
        Ld:
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L14
            android.view.View r2 = (android.view.View) r2
            goto L15
        L14:
            r2 = r0
        L15:
            if (r2 == 0) goto L26
            r1 = 0
            r2.setBackgroundColor(r1)
            android.view.ViewParent r2 = r2.getParent()
            boolean r1 = r2 instanceof android.view.View
            if (r1 == 0) goto L14
            android.view.View r2 = (android.view.View) r2
            goto L15
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.voice.motionkit.O.h(android.widget.PopupWindow):void");
    }

    public static final String i(String str) {
        if (kotlin.jvm.internal.p.d(str, "uPxPerDp")) {
            return str;
        }
        return "uR" + La.H.R0(str, "u");
    }

    public static final PopupWindow j(FrameLayout frameLayout) {
        PopupWindow popupWindow = new PopupWindow((View) frameLayout, 32, 32, false);
        popupWindow.setTouchable(false);
        popupWindow.setClippingEnabled(false);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        frameLayout.setBackgroundColor(0);
        frameLayout.setClipChildren(false);
        frameLayout.setClipToPadding(false);
        return popupWindow;
    }

    public static final void k(s7.k kVar, String str, float[] fArr) {
        int length = fArr.length;
        if (length == 1) {
            kVar.g(str, fArr[0]);
            return;
        }
        if (length == 2) {
            kVar.c(str, fArr[0], fArr[1]);
        } else if (length == 3) {
            kVar.e(str, fArr[0], fArr[1], fArr[2]);
        } else {
            if (length != 4) {
                return;
            }
            kVar.f(str, fArr[0], fArr[1], fArr[2], fArr[3]);
        }
    }

    public static final Map<String, float[]> l(EffectDefinition def) {
        float[] fArr;
        kotlin.jvm.internal.p.i(def, "def");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (s7.w wVar : def.i()) {
            String name = wVar.getName();
            if (wVar instanceof w.b) {
                fArr = new float[]{((w.b) wVar).getDefault()};
            } else if (wVar instanceof w.c) {
                w.c cVar = (w.c) wVar;
                fArr = new float[]{cVar.getDefaultX(), cVar.getDefaultY()};
            } else if (wVar instanceof w.d) {
                w.d dVar = (w.d) wVar;
                fArr = new float[]{dVar.getDefaultX(), dVar.getDefaultY(), dVar.getDefaultZ()};
            } else if (wVar instanceof w.e) {
                w.e eVar = (w.e) wVar;
                fArr = new float[]{eVar.getDefaultX(), eVar.getDefaultY(), eVar.getDefaultZ(), eVar.getDefaultW()};
            } else if (wVar instanceof w.a) {
                int defaultColor = ((w.a) wVar).getDefaultColor();
                fArr = new float[]{((defaultColor >> 16) & 255) / 255.0f, ((defaultColor >> 8) & 255) / 255.0f, (defaultColor & 255) / 255.0f, ((defaultColor >> 24) & 255) / 255.0f};
            } else {
                fArr = new float[]{0.0f};
            }
            linkedHashMap.put(name, fArr);
        }
        return linkedHashMap;
    }

    public static final float m(C3077q c3077q) {
        float fMax;
        float fG = c3077q.g("uDuration");
        if (fG <= 0.0f) {
            fG = 1.4f;
        }
        float fE = C5685n.e(c3077q.g("uRingGap"), 0.0f);
        float fG2 = c3077q.g("uExitDur");
        if (fG2 <= 0.0f) {
            fG2 = 0.25f;
        }
        float fM = C5685n.m(c3077q.g("uRefractFadeAt") * 0.01f, 0.02f, 0.98f);
        float f10 = (fM + ((1.0f - fM) * 0.55f)) * fG;
        if (c3077q.g("uRings") > 1.5f) {
            float f11 = fG / WATER_DESIGN_TOTAL;
            float f12 = f11 * 0.45f * 0.45f;
            fMax = Math.max((1.1f * f11) + f12, fE + (f11 * 0.917f) + f12);
        } else {
            fMax = c3077q.g("uHold") < 0.5f ? fG + (fG2 * 0.45f) : fG;
        }
        return C5685n.e(Math.min(fMax, Math.min(fG, f10)), 0.05f);
    }

    public static final EffectDefinition n(EffectDefinition effectDefinition, Map<String, float[]> map) {
        s7.w eVar;
        s7.w cVar;
        kotlin.jvm.internal.p.i(effectDefinition, "<this>");
        if (map == null || map.isEmpty()) {
            return effectDefinition;
        }
        List<s7.w> listI = effectDefinition.i();
        ArrayList arrayList = new ArrayList(C1174w.x(listI, 10));
        for (s7.w wVar : listI) {
            float[] fArr = map.get(wVar.getName());
            if (fArr != null) {
                if (wVar instanceof w.b) {
                    cVar = new w.b(wVar.getName(), fArr.length > 0 ? fArr[0] : ((w.b) wVar).getDefault(), ((w.b) wVar).d(), wVar.getLabel());
                } else if (wVar instanceof w.c) {
                    cVar = new w.c(wVar.getName(), fArr.length > 0 ? fArr[0] : ((w.c) wVar).getDefaultX(), 1 < fArr.length ? fArr[1] : ((w.c) wVar).getDefaultY(), wVar.getLabel());
                } else {
                    if (wVar instanceof w.d) {
                        eVar = new w.d(wVar.getName(), fArr.length > 0 ? fArr[0] : ((w.d) wVar).getDefaultX(), 1 < fArr.length ? fArr[1] : ((w.d) wVar).getDefaultY(), 2 < fArr.length ? fArr[2] : ((w.d) wVar).getDefaultZ(), wVar.getLabel());
                    } else if (wVar instanceof w.e) {
                        eVar = new w.e(wVar.getName(), fArr.length > 0 ? fArr[0] : ((w.e) wVar).getDefaultX(), 1 < fArr.length ? fArr[1] : ((w.e) wVar).getDefaultY(), 2 < fArr.length ? fArr[2] : ((w.e) wVar).getDefaultZ(), 3 < fArr.length ? fArr[3] : ((w.e) wVar).getDefaultW(), wVar.getLabel());
                    }
                    wVar = eVar;
                }
                wVar = cVar;
            }
            arrayList.add(wVar);
        }
        return EffectDefinition.b(effectDefinition, null, null, null, arrayList, null, false, null, 119, null);
    }
}
