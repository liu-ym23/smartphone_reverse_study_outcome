package com.stepos.ailauncher.contract.api.aispace;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/aispace/IAiSpaceTabView;", "", "LY8/t;", "onTabCreate", "()V", "onTabSelected", "onTabUnselected", "onTabDestroy", "", "onBackPressed", "()Z", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IAiSpaceTabView {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean onBackPressed(IAiSpaceTabView iAiSpaceTabView) {
            return IAiSpaceTabView.super.onBackPressed();
        }

        @Deprecated
        public static void onTabCreate(IAiSpaceTabView iAiSpaceTabView) {
            IAiSpaceTabView.super.onTabCreate();
        }

        @Deprecated
        public static void onTabDestroy(IAiSpaceTabView iAiSpaceTabView) {
            IAiSpaceTabView.super.onTabDestroy();
        }

        @Deprecated
        public static void onTabSelected(IAiSpaceTabView iAiSpaceTabView) {
            IAiSpaceTabView.super.onTabSelected();
        }

        @Deprecated
        public static void onTabUnselected(IAiSpaceTabView iAiSpaceTabView) {
            IAiSpaceTabView.super.onTabUnselected();
        }
    }

    default boolean onBackPressed() {
        return false;
    }

    default void onTabCreate() {
    }

    default void onTabDestroy() {
    }

    default void onTabSelected() {
    }

    default void onTabUnselected() {
    }
}
