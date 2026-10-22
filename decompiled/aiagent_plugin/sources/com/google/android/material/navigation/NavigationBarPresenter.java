package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.view.menu.d;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.a;
import com.google.android.material.internal.ParcelableSparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class NavigationBarPresenter implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MenuBuilder f13494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NavigationBarMenuView f13495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13497d;

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        ParcelableSparseArray badgeSavedStates;
        int selectedItemId;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel r3) {
            this.selectedItemId = r3.readInt();
            this.badgeSavedStates = (ParcelableSparseArray) ZeusTransformUtils.preCheckCast(r3.readParcelable(getClass().getClassLoader()), ParcelableSparseArray.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.selectedItemId);
            r1.writeParcelable(this.badgeSavedStates, 0);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public void onCloseMenu(MenuBuilder r1, boolean r2) {
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean onSubMenuSelected(SubMenuBuilder r1) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public void setCallback(d.a r2) {
        d.a r1 = (d.a) ZeusTransformUtils.wrapperContextForParams(r2, d.a.class, "com.obric.aiagent.plugin");
    }

    public NavigationBarPresenter() {
        this.f13496c = false;
    }

    public void a(NavigationBarMenuView r1) {
        this.f13495b = r1;
    }

    @Override // androidx.appcompat.view.menu.d
    public void initForMenu(Context r3, MenuBuilder r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f13494a = r4;
        this.f13495b.initialize(r4);
    }

    @Override // androidx.appcompat.view.menu.d
    public void updateMenuView(boolean r2) {
        if (this.f13496c == false) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        this.f13495b.buildMenuView();
        return;
    L7:
        this.f13495b.updateMenuView();
    }

    public void a(int r1) {
        this.f13497d = r1;
    }

    @Override // androidx.appcompat.view.menu.d
    public int getId() {
        return this.f13497d;
    }

    @Override // androidx.appcompat.view.menu.d
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState();
        r0.selectedItemId = this.f13495b.getSelectedItemId();
        r0.badgeSavedStates = a.a(this.f13495b.getBadgeDrawables());
        return r0;
    }

    @Override // androidx.appcompat.view.menu.d
    public void onRestoreInstanceState(Parcelable r4) {
        Parcelable r5 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r4, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SavedState.class) == false) goto L6;
        this.f13495b.tryRestoreSelectedItemId(((SavedState) ZeusTransformUtils.preCheckCast(r5, SavedState.class, "com.obric.aiagent.plugin")).selectedItemId);
        SparseArray<BadgeDrawable> r6 = a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f13495b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ((SavedState) ZeusTransformUtils.preCheckCast(r5, SavedState.class, "com.obric.aiagent.plugin")).badgeSavedStates);
        this.f13495b.restoreBadgeDrawables(r6);
        return;
    }

    public void a(boolean r1) {
        this.f13496c = r1;
    }
}
