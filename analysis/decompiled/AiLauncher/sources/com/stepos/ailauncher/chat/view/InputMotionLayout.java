package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.view.input.InputBarMotionSpec;
import h8.C4148a;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import q5.C5155a;
import v9.C5685n;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u0019J\u000f\u0010\u001f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001f\u0010\u0015JI\u0010'\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\"\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\"j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`#2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060%H\u0002¢\u0006\u0004\b'\u0010(J\u0019\u0010)\u001a\u0004\u0018\u00010 2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010*R\"\u0010,\u001a\u00020+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00102\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R\u0014\u0010<\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010/R\u0014\u0010>\u001a\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010/¨\u0006?"}, d2 = {"Lcom/stepos/ailauncher/chat/view/InputMotionLayout;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "LY8/t;", "onMeasure", "(II)V", "endHeight", "", "p", "u0", "(IF)Ljava/lang/Integer;", "n0", "()I", "mode", "", "p0", "(I)Ljava/lang/String;", "v", "t0", "id", "r0", "s0", "m0", "Landroid/view/View;", "child", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "cache", "", "visiting", "q0", "(Landroid/view/View;Ljava/util/HashMap;Ljava/util/Set;)I", "o0", "(I)Landroid/view/View;", "", "snappedToUnfocused", "Z", "getSnappedToUnfocused", "()Z", "setSnappedToUnfocused", "(Z)V", "drivenProgress", "F", "getDrivenProgress", "()F", "setDrivenProgress", "(F)V", "lastTrustedHeight", "I", "focusedWrapHeight", "getRestingAtUnfocused", "restingAtUnfocused", "getEndpointClaimIsStale", "endpointClaimIsStale", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InputMotionLayout extends MotionLayout {
    private float drivenProgress;
    private int focusedWrapHeight;
    private int lastTrustedHeight;
    private boolean snappedToUnfocused;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputMotionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    private final boolean getEndpointClaimIsStale() {
        return getCurrentState() == R$id.state_compact_single_row && this.drivenProgress > 0.0f && !this.snappedToUnfocused;
    }

    private final boolean getRestingAtUnfocused() {
        if (getCurrentState() == R$id.state_compact_single_row) {
            return this.drivenProgress <= 0.0f || this.snappedToUnfocused;
        }
        return false;
    }

    public final float getDrivenProgress() {
        return this.drivenProgress;
    }

    public final boolean getSnappedToUnfocused() {
        return this.snappedToUnfocused;
    }

    public final int m0() {
        String str;
        HashMap<Integer, Integer> map = new HashMap<>(getChildCount());
        boolean z10 = C5155a.enabled;
        StringBuilder sb2 = z10 ? new StringBuilder() : null;
        int childCount = getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            String strR0 = z10 ? r0(childAt.getId()) : null;
            if (childAt.getVisibility() != 8) {
                kotlin.jvm.internal.p.f(childAt);
                int iQ0 = q0(childAt, map, new LinkedHashSet());
                if (z10) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
                    if (bVar == null) {
                        str = "";
                    } else {
                        int i12 = bVar.f12644j;
                        if (i12 != -1) {
                            str = "|t2b=" + r0(i12);
                        } else {
                            int i13 = bVar.f12646k;
                            str = i13 != -1 ? "|b2t=" + r0(i13) : "|indep";
                        }
                    }
                    kotlin.jvm.internal.p.f(sb2);
                    sb2.append(strR0 + "=" + iQ0 + "(vis=" + t0(childAt.getVisibility()) + ",mh=" + childAt.getMeasuredHeight() + ",tm=" + (bVar != null ? ((ViewGroup.MarginLayoutParams) bVar).topMargin : 0) + ",bm=" + (bVar != null ? ((ViewGroup.MarginLayoutParams) bVar).bottomMargin : 0) + str + "),");
                }
                if (iQ0 > i10) {
                    i10 = iQ0;
                }
            } else if (sb2 != null) {
                sb2.append(strR0 + "=GONE,");
            }
        }
        if (z10) {
            C5155a c5155a = C5155a.INSTANCE;
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[MEASURE] children: " + ((Object) sb2) + " → max=" + i10, false, 4, null);
            }
        }
        return i10;
    }

    public final int n0() {
        androidx.constraintlayout.widget.c cVarN;
        int i10 = R$id.bg_input;
        View viewFindViewById = findViewById(i10);
        if (viewFindViewById == null || viewFindViewById.getMeasuredHeight() <= 0 || (cVarN = N(R$id.state_expanded_multi_row)) == null) {
            return 0;
        }
        c.b bVar = cVarN.C(i10).f12725e;
        int[] iArr = {R$id.layout_btn_voice, R$id.btn_more, R$id.btn_text_send, R$id.btn_camera};
        int i11 = iArr[0];
        View viewFindViewById2 = findViewById(i11);
        c.b bVar2 = cVarN.C(i11).f12725e;
        Integer numValueOf = Integer.valueOf(bVar2.f12751J + (viewFindViewById2 != null ? viewFindViewById2.getMeasuredHeight() : 0) + bVar2.f12752K);
        int iD0 = Z8.r.d0(iArr);
        int i12 = 1;
        if (1 <= iD0) {
            while (true) {
                int i13 = iArr[i12];
                View viewFindViewById3 = findViewById(i13);
                c.b bVar3 = cVarN.C(i13).f12725e;
                Integer numValueOf2 = Integer.valueOf(bVar3.f12751J + (viewFindViewById3 != null ? viewFindViewById3.getMeasuredHeight() : 0) + bVar3.f12752K);
                if (numValueOf.compareTo(numValueOf2) < 0) {
                    numValueOf = numValueOf2;
                }
                if (i12 == iD0) {
                    break;
                }
                i12++;
            }
        }
        int iIntValue = numValueOf.intValue();
        if (iIntValue <= 0) {
            return 0;
        }
        return InputBarMotionSpec.INSTANCE.d(viewFindViewById.getMeasuredHeight(), bVar.f12751J, 0, iIntValue, 0);
    }

    public final View o0(int id) {
        if (id == -1 || id == 0) {
            return null;
        }
        return findViewById(id);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout, androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        float f10 = this.drivenProgress;
        int measuredHeight = getMeasuredHeight();
        C5155a c5155a = C5155a.INSTANCE;
        if (C5155a.enabled) {
            C4148a.k(C5155a.TAG, "[MEASURE] enter progress=" + f10 + " superH=" + measuredHeight + " mode=" + p0(mode) + " inSize=" + size + " curState=" + s0(getCurrentState()), false, 4, null);
        }
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[MEASURE] skip: mode=" + p0(mode) + " 非 wrap_content", false, 4, null);
                return;
            }
            return;
        }
        if (getEndpointClaimIsStale()) {
            int i10 = this.lastTrustedHeight;
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[MEASURE] hold(stale endpoint) superH=" + measuredHeight + " held=" + i10 + " progress=" + f10, false, 4, null);
            }
            if (i10 > 0) {
                setMeasuredDimension(getMeasuredWidth(), i10);
                return;
            }
            return;
        }
        if (!getRestingAtUnfocused()) {
            int iN0 = n0();
            if (f10 >= 1.0f) {
                this.focusedWrapHeight = measuredHeight;
            }
            Integer numValueOf = Integer.valueOf(iN0);
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            Integer numU0 = u0(numValueOf != null ? numValueOf.intValue() : this.focusedWrapHeight, f10);
            this.lastTrustedHeight = numU0 != null ? numU0.intValue() : measuredHeight;
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[MEASURE] skip: curState=" + s0(getCurrentState()) + " snapped=" + this.snappedToUnfocused + " 非「完整停在单行态」,信 super=" + measuredHeight + " tracked=" + numU0 + " (drivenProgress=" + f10 + ")", false, 4, null);
            }
            if (numU0 != null) {
                setMeasuredDimension(getMeasuredWidth(), numU0.intValue());
                return;
            }
            return;
        }
        int iM0 = m0();
        if (iM0 <= 0) {
            if (C5155a.enabled) {
                C4148a.k(C5155a.TAG, "[MEASURE] skip: expected=" + iM0, false, 4, null);
                return;
            }
            return;
        }
        int iMin = mode == Integer.MIN_VALUE ? Math.min(iM0, size) : iM0;
        this.lastTrustedHeight = iMin;
        boolean z10 = Math.abs(getMeasuredHeight() - iMin) > 2;
        if (C5155a.enabled) {
            C4148a.k(C5155a.TAG, "[MEASURE] decide(state_compact_single_row) superH=" + measuredHeight + " expected=" + iM0 + " capped=" + iMin + " override=" + z10 + " progress=" + f10, false, 4, null);
        }
        if (z10) {
            setMeasuredDimension(getMeasuredWidth(), iMin);
        }
    }

    public final String p0(int mode) {
        return mode != Integer.MIN_VALUE ? mode != 0 ? mode != 1073741824 ? "?" : "EXACTLY" : "UNSPECIFIED" : "AT_MOST";
    }

    public final int q0(View child, HashMap<Integer, Integer> cache, Set<Integer> visiting) {
        View viewO0;
        int iQ0;
        int id = child.getId();
        Integer num = cache.get(Integer.valueOf(id));
        if (num != null) {
            return num.intValue();
        }
        if (id != -1 && !visiting.add(Integer.valueOf(id))) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (bVar == null) {
            visiting.remove(Integer.valueOf(id));
            return 0;
        }
        int measuredHeight = child.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i10 = bVar.f12644j;
        int i11 = bVar.f12646k;
        if (i10 != -1) {
            View viewO02 = o0(i10);
            if (viewO02 != null && viewO02.getVisibility() != 8) {
                iQ0 = q0(viewO02, cache, visiting);
                measuredHeight += iQ0;
            }
        } else if (i11 != -1 && (viewO0 = o0(i11)) != null && viewO0.getVisibility() != 8) {
            iQ0 = q0(viewO0, cache, visiting);
            measuredHeight += iQ0;
        }
        if (id != -1) {
            cache.put(Integer.valueOf(id), Integer.valueOf(measuredHeight));
            visiting.remove(Integer.valueOf(id));
        }
        return measuredHeight;
    }

    public final String r0(int id) {
        Object objB;
        if (id == -1) {
            return "no-id";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getResources().getResourceEntryName(id));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str = "id=" + id;
        if (Result.g(objB)) {
            objB = str;
        }
        return (String) objB;
    }

    public final String s0(int id) {
        Object objB;
        if (id == -1 || id == -1) {
            return "UNSET";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getResources().getResourceEntryName(id));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str = "id=" + id;
        if (Result.g(objB)) {
            objB = str;
        }
        return (String) objB;
    }

    public final void setDrivenProgress(float f10) {
        this.drivenProgress = f10;
    }

    public final void setSnappedToUnfocused(boolean z10) {
        this.snappedToUnfocused = z10;
    }

    public final String t0(int v10) {
        return v10 != 0 ? v10 != 4 ? v10 != 8 ? "?" : "G" : "I" : ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
    }

    public final Integer u0(int endHeight, float p10) {
        int iM0;
        if (endHeight > 0 && (iM0 = m0()) > 0 && iM0 < endHeight) {
            return Integer.valueOf(Math.round(iM0 + (C5685n.m(p10, 0.0f, 1.0f) * (endHeight - iM0))));
        }
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputMotionLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public /* synthetic */ InputMotionLayout(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
