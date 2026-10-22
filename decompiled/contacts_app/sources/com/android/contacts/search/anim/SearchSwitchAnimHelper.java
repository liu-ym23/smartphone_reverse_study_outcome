package com.android.contacts.search.anim;

import android.view.View;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatable;
import com.obric.common.oea.foundation.animation.builder.PropertyAnimatableKt;
import com.obric.common.oea.foundation.animation.spec.AnimationSpecKt;
import com.obric.common.oea.foundation.animation.token.AnimationProperty;
import com.obric.common.oea.foundation.animation.token.Token;
import com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchSwitchAnimHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016J\u0016\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J&\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/contacts/search/anim/SearchSwitchAnimHelper;", "Lcom/obric/common/oea/style/scene/common/AbstractModeSwitchAnimComposer;", "()V", "cancelButton", "Landroid/view/View;", "searchBox", "searchBoxFullWidth", "", "searchBoxParentContent", "", "searchBoxShrunkWidth", "searchBoxTransitionY", "searchPageContainer", "searchResultContainer", "addSearchBoxParentContent", "view", "hideViewWhenAlphaBecomeZero", "", "handleSingleEnterAnimEnd", "", "finished", "handleSingleExitAnimEnd", "makeEnterAnims", "", "Lcom/obric/common/oea/foundation/animation/builder/PropertyAnimatable$Builder;", "makeExitAnims", "release", "setCancelButton", "setSearchBox", "fullWidth", "targetWidth", "transitionY", "setSearchPageContainer", "setSearchResultContainer", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SearchSwitchAnimHelper extends AbstractModeSwitchAnimComposer {
    public static final Companion Companion = null;
    private static final String TAG = "SearchSwitchAnimHelper";
    private View cancelButton;
    private View searchBox;
    private int searchBoxFullWidth;
    private List<View> searchBoxParentContent;
    private int searchBoxShrunkWidth;
    private int searchBoxTransitionY;
    private View searchPageContainer;
    private View searchResultContainer;

    /* JADX INFO: compiled from: SearchSwitchAnimHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/search/anim/SearchSwitchAnimHelper$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SearchSwitchAnimHelper() {
        super(1000);
        this.searchBoxFullWidth = -1;
    }

    public final SearchSwitchAnimHelper setSearchBox(View r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.searchBox = r2;
        this.searchBoxFullWidth = r3;
        this.searchBoxShrunkWidth = r4;
        this.searchBoxTransitionY = r5;
        return this;
    }

    public final SearchSwitchAnimHelper setCancelButton(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.cancelButton = r2;
        if (r3 == false) goto L5;
        r2.setTag(R.id.anim_tag_view_gone_when_alpha_become_zero, true);
    L5:
        return this;
    }

    public final SearchSwitchAnimHelper setSearchPageContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.searchPageContainer = r2;
        return this;
    }

    public final SearchSwitchAnimHelper setSearchResultContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.searchResultContainer = r2;
        return this;
    }

    public final SearchSwitchAnimHelper addSearchBoxParentContent(View r2, boolean r3) {
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
        this.searchBox = null;
        this.cancelButton = null;
        this.searchPageContainer = null;
        this.searchResultContainer = null;
        this.searchBoxParentContent = null;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public List<PropertyAnimatable.Builder> makeEnterAnims() {
        ArrayList r1 = new ArrayList();
        View r2 = this.searchPageContainer;
        if (r2 == null) goto L5;
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r2, 0.0f, 1, null), AnimationProperty.FloatProperty.TRANSLATION_Y, Float.valueOf(r2.getTranslationY()), this.searchBoxTransitionY, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 16, null));
    L5:
        View r3 = this.searchResultContainer;
        if (r3 != null) goto L8;
    L17:
        View r4 = this.searchBox;
        if (r4 != null) goto L20;
    L23:
        View r5 = this.cancelButton;
        if (r5 != null) goto L26;
    L29:
        List<View> r0 = this.searchBoxParentContent;
        if (r0 == null) goto L35;
        Iterator<T> r6 = r0.iterator();
    L33:
        if (r6.hasNext() == false) goto L35;
        View r7 = (View) r6.next();
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r7, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r7.getAlpha()), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 16, null));
    L35:
        return r1;
    L26:
        if (r5.getVisibility() == 0) goto L28;
        r5.setVisibility(0);
        r5.setAlpha(0.0f);
    L28:
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r5, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r5.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_4, Token.Delay.OUI_ANIMATION_DELAY_SHORT_3, Token.Easing.OUI_ANIMATION_EASING_EASE_OUT_QUAD), null, 16, null));
        goto L29
    L20:
        if (this.searchBoxShrunkWidth > 0) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "enterSearchMode cant play search box width anim, searchBoxFullWidth < 0");
        goto L23
    L22:
        r1.add(PropertyAnimatable.Builder.ofInt$default(PropertyAnimatableKt.animator$default(r4, 0.0f, 1, null), AnimationProperty.IntProperty.WIDTH, Integer.valueOf(r4.getWidth()), this.searchBoxShrunkWidth, AnimationSpecKt.springInt$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_2, 0, 4, null), null, 16, null));
        goto L23
    L8:
        if (r3.getVisibility() == 0) goto L11;
        r3.setVisibility(0);
    L11:
        if (r3.getAlpha() != 0.0f) goto L13;
        boolean r8 = true;
    L14:
        if (r8 == true) goto L16;
        r3.setAlpha(0.0f);
    L16:
        r1.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r3, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r3.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_IN_QUAD), null, 16, null));
        goto L17
    L13:
        r8 = false;
        goto L14
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void handleSingleEnterAnimEnd(View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (r4 == true) goto L5;
        return;
    L5:
        boolean r0 = true;
        if (Intrinsics.areEqual(r3.getTag(R.id.anim_tag_view_gone_when_alpha_become_zero), true) == false) goto L16;
        List<View> r2 = this.searchBoxParentContent;
        if (r2 != null) goto L10;
    L12:
        r0 = false;
    L13:
        if (r0 == false) goto L17;
        r3.setVisibility(8);
        return;
    L17:
        return;
    L10:
        if (r2.contains(r3) != true) goto L12;
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public List<PropertyAnimatable.Builder> makeExitAnims() {
        ArrayList r0 = new ArrayList();
        View r1 = this.searchPageContainer;
        if (r1 == null) goto L5;
        r0.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r1, 0.0f, 1, null), AnimationProperty.FloatProperty.TRANSLATION_Y, Float.valueOf(r1.getTranslationY()), 0.0f, AnimationSpecKt.spring$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1, 0, 4, null), null, 16, null));
    L5:
        View r2 = this.searchResultContainer;
        if (r2 == null) goto L8;
        r0.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r2, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r2.getAlpha()), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_IN_QUAD), null, 16, null));
    L8:
        View r3 = this.searchBox;
        if (r3 != null) goto L11;
    L14:
        View r4 = this.cancelButton;
        if (r4 == null) goto L17;
        r0.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r4, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r4.getAlpha()), 0.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_1, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_LINEAR), null, 16, null));
    L17:
        List<View> r15 = this.searchBoxParentContent;
        if (r15 == null) goto L23;
        Iterator<T> r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L23;
        View r5 = (View) r16.next();
        r0.add(PropertyAnimatable.Builder.of$default(PropertyAnimatableKt.animator$default(r5, 0.0f, 1, null), AnimationProperty.FloatProperty.ALPHA, Float.valueOf(r5.getAlpha()), 1.0f, AnimationSpecKt.tween(Token.Duration.OUI_ANIMATION_DURATION_SHORT_2, Token.Delay.OUI_ANIMATION_DELAY_NONE, Token.Easing.OUI_ANIMATION_EASING_EASE_IN_QUAD), null, 16, null));
    L23:
        return r0;
    L11:
        if (this.searchBoxFullWidth > 0) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "searchBoxFullWidth <= 0: " + this.searchBoxFullWidth);
        goto L14
    L13:
        r0.add(PropertyAnimatable.Builder.ofInt$default(PropertyAnimatableKt.animator$default(r3, 0.0f, 1, null), AnimationProperty.IntProperty.WIDTH, Integer.valueOf(r3.getWidth()), this.searchBoxFullWidth, AnimationSpecKt.springInt$default(Token.Bounce.OUI_ANIMATION_BOUNCE_SMOOTH, Token.Duration.OUI_ANIMATION_DURATION_MEDIUM_1, 0, 4, null), null, 16, null));
        goto L14
    }

    @Override // com.obric.common.oea.style.scene.common.AbstractModeSwitchAnimComposer
    public void handleSingleExitAnimEnd(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r3 == true) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r2.getTag(R.id.anim_tag_view_gone_when_alpha_become_zero), true) == true) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.cancelButton, r2) == false) goto L12;
        r2.setVisibility(8);
        return;
    }
}
