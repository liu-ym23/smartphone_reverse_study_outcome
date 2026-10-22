package com.android.wm.shell;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> getValueImpl) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_BUBBLE_VIEW_INFO_EXECUTORS, Flags.FLAG_ENABLE_AUTO_TASK_STACK_CONTROLLER, Flags.FLAG_ENABLE_BUBBLE_ANYTHING, Flags.FLAG_ENABLE_BUBBLE_BAR, Flags.FLAG_ENABLE_BUBBLE_BAR_ON_PHONES, Flags.FLAG_ENABLE_BUBBLE_STASHING, Flags.FLAG_ENABLE_BUBBLE_TASK_VIEW_LISTENER, Flags.FLAG_ENABLE_BUBBLE_TO_FULLSCREEN, Flags.FLAG_ENABLE_BUBBLES_LONG_PRESS_NAV_HANDLE, Flags.FLAG_ENABLE_CREATE_ANY_BUBBLE, Flags.FLAG_ENABLE_DYNAMIC_INSETS_FOR_APP_LAUNCH, Flags.FLAG_ENABLE_FLEXIBLE_SPLIT, Flags.FLAG_ENABLE_FLEXIBLE_TWO_APP_SPLIT, Flags.FLAG_ENABLE_GSF, Flags.FLAG_ENABLE_MAGNETIC_SPLIT_DIVIDER, Flags.FLAG_ENABLE_NEW_BUBBLE_ANIMATIONS, Flags.FLAG_ENABLE_OPTIONAL_BUBBLE_OVERFLOW, Flags.FLAG_ENABLE_PIP2, Flags.FLAG_ENABLE_PIP_UMO_EXPERIENCE, Flags.FLAG_ENABLE_RECENTS_BOOKEND_TRANSITION, Flags.FLAG_ENABLE_RETRIEVABLE_BUBBLES, Flags.FLAG_ENABLE_SHELL_TOP_TASK_TRACKING, Flags.FLAG_ENABLE_TASK_VIEW_CONTROLLER_CLEANUP, Flags.FLAG_ENABLE_TASKBAR_NAVBAR_UNIFICATION, Flags.FLAG_ENABLE_TASKBAR_ON_PHONES, Flags.FLAG_ENABLE_TINY_TASKBAR, Flags.FLAG_FIX_MISSING_USER_CHANGE_CALLBACKS, Flags.FLAG_ONLY_REUSE_BUBBLED_TASK_WHEN_LAUNCHED_FROM_BUBBLE, Flags.FLAG_TASK_VIEW_REPOSITORY, ""}));
        this.mGetValueImpl = getValueImpl;
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean bubbleViewInfoExecutors() {
        return getValue(Flags.FLAG_BUBBLE_VIEW_INFO_EXECUTORS, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableAutoTaskStackController() {
        return getValue(Flags.FLAG_ENABLE_AUTO_TASK_STACK_CONTROLLER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableBubbleAnything() {
        return getValue(Flags.FLAG_ENABLE_BUBBLE_ANYTHING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableBubbleBar() {
        return getValue(Flags.FLAG_ENABLE_BUBBLE_BAR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableBubbleBarOnPhones() {
        return getValue(Flags.FLAG_ENABLE_BUBBLE_BAR_ON_PHONES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableBubbleStashing() {
        return getValue(Flags.FLAG_ENABLE_BUBBLE_STASHING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableBubbleTaskViewListener() {
        return getValue(Flags.FLAG_ENABLE_BUBBLE_TASK_VIEW_LISTENER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableBubbleToFullscreen() {
        return getValue(Flags.FLAG_ENABLE_BUBBLE_TO_FULLSCREEN, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableBubblesLongPressNavHandle() {
        return getValue(Flags.FLAG_ENABLE_BUBBLES_LONG_PRESS_NAV_HANDLE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableCreateAnyBubble() {
        return getValue(Flags.FLAG_ENABLE_CREATE_ANY_BUBBLE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableDynamicInsetsForAppLaunch() {
        return getValue(Flags.FLAG_ENABLE_DYNAMIC_INSETS_FOR_APP_LAUNCH, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableFlexibleSplit() {
        return getValue(Flags.FLAG_ENABLE_FLEXIBLE_SPLIT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableFlexibleTwoAppSplit() {
        return getValue(Flags.FLAG_ENABLE_FLEXIBLE_TWO_APP_SPLIT, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableGsf() {
        return getValue(Flags.FLAG_ENABLE_GSF, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableMagneticSplitDivider() {
        return getValue(Flags.FLAG_ENABLE_MAGNETIC_SPLIT_DIVIDER, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableNewBubbleAnimations() {
        return getValue(Flags.FLAG_ENABLE_NEW_BUBBLE_ANIMATIONS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableOptionalBubbleOverflow() {
        return getValue(Flags.FLAG_ENABLE_OPTIONAL_BUBBLE_OVERFLOW, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enablePip2() {
        return getValue(Flags.FLAG_ENABLE_PIP2, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enablePipUmoExperience() {
        return getValue(Flags.FLAG_ENABLE_PIP_UMO_EXPERIENCE, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableRecentsBookendTransition() {
        return getValue(Flags.FLAG_ENABLE_RECENTS_BOOKEND_TRANSITION, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableRetrievableBubbles() {
        return getValue(Flags.FLAG_ENABLE_RETRIEVABLE_BUBBLES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableShellTopTaskTracking() {
        return getValue(Flags.FLAG_ENABLE_SHELL_TOP_TASK_TRACKING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableTaskViewControllerCleanup() {
        return getValue(Flags.FLAG_ENABLE_TASK_VIEW_CONTROLLER_CLEANUP, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableTaskbarNavbarUnification() {
        return getValue(Flags.FLAG_ENABLE_TASKBAR_NAVBAR_UNIFICATION, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableTaskbarOnPhones() {
        return getValue(Flags.FLAG_ENABLE_TASKBAR_ON_PHONES, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean enableTinyTaskbar() {
        return getValue(Flags.FLAG_ENABLE_TINY_TASKBAR, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean fixMissingUserChangeCallbacks() {
        return getValue(Flags.FLAG_FIX_MISSING_USER_CHANGE_CALLBACKS, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean onlyReuseBubbledTaskWhenLaunchedFromBubble() {
        return getValue(Flags.FLAG_ONLY_REUSE_BUBBLED_TASK_WHEN_LAUNCHED_FROM_BUBBLE, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // com.android.wm.shell.FeatureFlags
    public boolean taskViewRepository() {
        return getValue(Flags.FLAG_TASK_VIEW_REPOSITORY, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    public boolean isFlagReadOnlyOptimized(String flagName) {
        if (this.mReadOnlyFlagsSet.contains(flagName) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isOptimizationEnabled() {
        return false;
    }

    protected boolean getValue(String flagName, Predicate<FeatureFlags> getter) {
        return this.mGetValueImpl.test(flagName, getter);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_BUBBLE_VIEW_INFO_EXECUTORS, Flags.FLAG_ENABLE_AUTO_TASK_STACK_CONTROLLER, Flags.FLAG_ENABLE_BUBBLE_ANYTHING, Flags.FLAG_ENABLE_BUBBLE_BAR, Flags.FLAG_ENABLE_BUBBLE_BAR_ON_PHONES, Flags.FLAG_ENABLE_BUBBLE_STASHING, Flags.FLAG_ENABLE_BUBBLE_TASK_VIEW_LISTENER, Flags.FLAG_ENABLE_BUBBLE_TO_FULLSCREEN, Flags.FLAG_ENABLE_BUBBLES_LONG_PRESS_NAV_HANDLE, Flags.FLAG_ENABLE_CREATE_ANY_BUBBLE, Flags.FLAG_ENABLE_DYNAMIC_INSETS_FOR_APP_LAUNCH, Flags.FLAG_ENABLE_FLEXIBLE_SPLIT, Flags.FLAG_ENABLE_FLEXIBLE_TWO_APP_SPLIT, Flags.FLAG_ENABLE_GSF, Flags.FLAG_ENABLE_MAGNETIC_SPLIT_DIVIDER, Flags.FLAG_ENABLE_NEW_BUBBLE_ANIMATIONS, Flags.FLAG_ENABLE_OPTIONAL_BUBBLE_OVERFLOW, Flags.FLAG_ENABLE_PIP2, Flags.FLAG_ENABLE_PIP_UMO_EXPERIENCE, Flags.FLAG_ENABLE_RECENTS_BOOKEND_TRANSITION, Flags.FLAG_ENABLE_RETRIEVABLE_BUBBLES, Flags.FLAG_ENABLE_SHELL_TOP_TASK_TRACKING, Flags.FLAG_ENABLE_TASK_VIEW_CONTROLLER_CLEANUP, Flags.FLAG_ENABLE_TASKBAR_NAVBAR_UNIFICATION, Flags.FLAG_ENABLE_TASKBAR_ON_PHONES, Flags.FLAG_ENABLE_TINY_TASKBAR, Flags.FLAG_FIX_MISSING_USER_CHANGE_CALLBACKS, Flags.FLAG_ONLY_REUSE_BUBBLED_TASK_WHEN_LAUNCHED_FROM_BUBBLE, Flags.FLAG_TASK_VIEW_REPOSITORY});
    }
}
