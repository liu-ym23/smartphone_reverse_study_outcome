package com.obric.common.oea.style.scene.search;

import android.view.View;
import android.view.ViewGroup;
import com.GlobalProxyLancet;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.style.R;
import com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: SearchModeSwitchAnimHelperType2.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/common/oea/style/scene/search/SearchModeSwitchAnimHelperType2;", "Lcom/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer;", "()V", "searchBox", "Landroid/view/View;", "searchBoxAffiliatedContent", "", "searchBoxFullWidth", "", "searchBoxInitialWidth", "searchBoxParentContent", "addSearchBoxAffiliatedContent", "view", "hideViewWhenAlphaBecomeZero", "", "addSearchBoxParentContent", "enterWithoutAnim", "", "exitWithoutAnim", "handleSingleEnterAnimEnd", "finished", "handleSingleExitAnimEnd", "hideViewIfNeeded", "makeEnterAnims", "", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "makeExitAnims", "release", "setSearchBox", "fullWidth", "initialWidth", "Companion", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchModeSwitchAnimHelperType2 extends AbstractModeSwitchAnimComposer {
    public static final Companion Companion = null;
    private static final String TAG = "SearchTransitionAnimHelperType2";
    private View searchBox;
    private List<View> searchBoxAffiliatedContent;
    private int searchBoxFullWidth;
    private int searchBoxInitialWidth;
    private List<View> searchBoxParentContent;

    /* JADX INFO: compiled from: SearchModeSwitchAnimHelperType2.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/search/SearchModeSwitchAnimHelperType2$Companion;", "", "()V", "TAG", "", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SearchModeSwitchAnimHelperType2() {
        super(1000);
        this.searchBoxFullWidth = -1;
        this.searchBoxInitialWidth = -1;
    }

    public final SearchModeSwitchAnimHelperType2 setSearchBox(View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.searchBox = r2;
        this.searchBoxFullWidth = r3;
        this.searchBoxInitialWidth = r4;
        return this;
    }

    public final SearchModeSwitchAnimHelperType2 addSearchBoxAffiliatedContent(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (this.searchBoxAffiliatedContent != null) goto L5;
        this.searchBoxAffiliatedContent = new ArrayList();
    L5:
        List<View> r0 = this.searchBoxAffiliatedContent;
        if (r0 == null) goto L8;
        r0.add(r2);
    L8:
        if (r3 == false) goto L10;
        r2.setTag(R.id.anim_tag_view_gone_when_alpha_become_zero, true);
    L10:
        return this;
    }

    public final SearchModeSwitchAnimHelperType2 addSearchBoxParentContent(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (this.searchBoxParentContent != null) goto L5;
        this.searchBoxParentContent = new ArrayList();
    L5:
        List<View> r0 = this.searchBoxParentContent;
        if (r0 == null) goto L8;
        r0.add(r2);
    L8:
        if (r3 == false) goto L10;
        r2.setTag(R.id.anim_tag_view_gone_when_alpha_become_zero, true);
    L10:
        return this;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void release() {
        super.release();
        View r1 = (View) null;
        this.searchBox = null;
        List r2 = (List) null;
        this.searchBoxAffiliatedContent = null;
        this.searchBoxParentContent = null;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public List<PropertyAnimatable.Builder> makeEnterAnims() {
        ArrayList r1 = new ArrayList();
        List<View> r2 = this.searchBoxAffiliatedContent;
        if (r2 == null) goto L11;
        Iterator<T> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        View r7 = (View) r3.next();
        if (r7.getVisibility() == 0) goto L10;
        r7.setVisibility(0);
        r7.setAlpha(0.0f);
    L10:
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r7, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r7.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_IN_QUAD), null, 16, null));
    L11:
        View r4 = this.searchBox;
        if (r4 != null) goto L14;
    L19:
        List<View> r0 = this.searchBoxParentContent;
        if (r0 == null) goto L25;
        Iterator<T> r5 = r0.iterator();
    L23:
        if (r5.hasNext() == false) goto L25;
        View r6 = (View) r5.next();
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r6, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r6.getAlpha()), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 16, null));
    L25:
        return r1;
    L14:
        if (this.searchBoxInitialWidth >= 0) goto L16;
    L18:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "enterSearchMode cant play search box width anim, searchBoxInitialWidth < 0 || searchBoxFullWidth < 0");
        goto L19
    L16:
        if (this.searchBoxFullWidth <= 0) goto L18;
        r1.add(PropertyAnimatable.Builder.ofInt$default(PropertyAnimatableKt.animator$default(r4, 0.0f, 1, null), AnimationProperty.IntProperty.WIDTH, Integer.valueOf(r4.getWidth()), this.searchBoxFullWidth, AnimationSpecKt.springInt$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 16, null));
        goto L19
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void handleSingleEnterAnimEnd(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (r4 == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3.getTag(R.id.anim_tag_view_gone_when_alpha_become_zero), true) == false) goto L13;
        List<View> r2 = this.searchBoxParentContent;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.contains(r3) != true) goto L15;
        r3.setVisibility(8);
        return;
    L15:
        return;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public List<PropertyAnimatable.Builder> makeExitAnims() {
        ArrayList r0 = new ArrayList();
        List<View> r1 = this.searchBoxAffiliatedContent;
        if (r1 == null) goto L8;
        Iterator<T> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        View r5 = (View) r2.next();
        r0.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r5, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r5.getAlpha()), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 16, null));
    L8:
        View r3 = this.searchBox;
        if (r3 != null) goto L11;
    L14:
        List<View> r15 = this.searchBoxParentContent;
        if (r15 == null) goto L23;
        Iterator<T> r16 = r15.iterator();
    L18:
        if (r16.hasNext() == false) goto L23;
        View r4 = (View) r16.next();
        if (r4.getVisibility() == 0) goto L22;
        r4.setVisibility(0);
        r4.setAlpha(0.0f);
    L22:
        r0.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r4, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r4.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_IN_QUAD), null, 16, null));
    L23:
        return r0;
    L11:
        if (this.searchBoxInitialWidth >= 0) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "exitSearchMode, cant play search box width anim, searchBoxFullWidth <= 0");
        goto L14
    L13:
        r0.add(PropertyAnimatable.Builder.ofInt$default(PropertyAnimatableKt.animator$default(r3, 0.0f, 1, null), AnimationProperty.IntProperty.WIDTH, Integer.valueOf(r3.getWidth()), this.searchBoxInitialWidth, AnimationSpecKt.springInt$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1, 0, 4, null), null, 16, null));
        goto L14
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void handleSingleExitAnimEnd(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (r4 == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r3.getTag(R.id.anim_tag_view_gone_when_alpha_become_zero), true) == false) goto L13;
        List<View> r2 = this.searchBoxAffiliatedContent;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.contains(r3) != true) goto L15;
        r3.setVisibility(8);
        return;
    L15:
        return;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void enterWithoutAnim() {
        super.enterWithoutAnim();
        List<View> r0 = this.searchBoxAffiliatedContent;
        if (r0 == null) goto L11;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L11;
        View r2 = (View) r1.next();
        if (r2.getVisibility() == 0) goto L10;
        r2.setVisibility(0);
    L10:
        r2.setAlpha(1.0f);
    L11:
        View r3 = this.searchBox;
        if (r3 != null) goto L14;
    L21:
        List<View> r4 = this.searchBoxParentContent;
        if (r4 == null) goto L27;
        Iterator<T> r5 = r4.iterator();
    L25:
        if (r5.hasNext() == false) goto L32;
        View r6 = (View) r5.next();
        r6.setAlpha(0.0f);
        hideViewIfNeeded(r6);
        goto L25
    L32:
        return;
    L27:
        return;
    L14:
        if (this.searchBoxInitialWidth >= 0) goto L16;
    L20:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "enterWithoutAnim error, searchBoxInitialWidth < 0 || searchBoxFullWidth < 0");
        goto L21
    L16:
        if (this.searchBoxFullWidth <= 0) goto L20;
        ViewGroup.LayoutParams r7 = r3.getLayoutParams();
        if ((r7 instanceof ViewGroup.LayoutParams) == false) goto L21;
        r7.width = RangesKt.coerceAtLeast(this.searchBoxFullWidth, 0);
        r3.setLayoutParams(r7);
        goto L21
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void exitWithoutAnim() {
        super.exitWithoutAnim();
        List<View> r0 = this.searchBoxAffiliatedContent;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        View r2 = (View) r1.next();
        r2.setAlpha(0.0f);
        hideViewIfNeeded(r2);
    L8:
        View r3 = this.searchBox;
        if (r3 == null) goto L13;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.LayoutParams) == false) goto L13;
        r4.width = RangesKt.coerceAtLeast(this.searchBoxInitialWidth, 0);
        r3.setLayoutParams(r4);
    L13:
        List<View> r5 = this.searchBoxParentContent;
        if (r5 == null) goto L22;
        Iterator<T> r6 = r5.iterator();
    L17:
        if (r6.hasNext() == false) goto L27;
        View r7 = (View) r6.next();
        if (r7.getVisibility() == 0) goto L21;
        r7.setVisibility(0);
    L21:
        r7.setAlpha(1.0f);
        goto L17
    L27:
        return;
    }

    private final void hideViewIfNeeded(View r2) {
        if (Intrinsics.areEqual(r2.getTag(R.id.anim_tag_view_gone_when_alpha_become_zero), true) == false) goto L6;
        r2.setVisibility(8);
        return;
    }
}
