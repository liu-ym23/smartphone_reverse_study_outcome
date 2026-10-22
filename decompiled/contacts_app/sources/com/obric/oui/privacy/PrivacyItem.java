package com.obric.oui.privacy;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPrivacySheetConfig.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/privacy/PrivacyItem;", "", "()V", "PermissionItem", "SwitchItem", "Lcom/obric/oui/privacy/PrivacyItem$SwitchItem;", "Lcom/obric/oui/privacy/PrivacyItem$PermissionItem;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PrivacyItem {

    /* JADX INFO: compiled from: OPrivacySheetConfig.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/privacy/PrivacyItem$PermissionItem;", "Lcom/obric/oui/privacy/PrivacyItem;", "description", "", "permissions", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getPermissions", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PermissionItem extends PrivacyItem {
        private final String description;
        private final List<String> permissions;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PermissionItem copy$default(PermissionItem r0, String r1, List r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.description;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.permissions;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.description;
        }

        public final List<String> component2() {
            return this.permissions;
        }

        public final PermissionItem copy(String r1, List<String> r2) {
            Intrinsics.checkNotNullParameter(r1, "description");
            Intrinsics.checkNotNullParameter(r2, "permissions");
            return new PermissionItem(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PermissionItem) == true) goto L8;
            return false;
        L8:
            PermissionItem r6 = (PermissionItem) r5;
            if (Intrinsics.areEqual(this.description, r6.description) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.permissions, r6.permissions) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.description.hashCode() * 31) + this.permissions.hashCode();
        }

        public String toString() {
            return "PermissionItem(description=" + this.description + ", permissions=" + this.permissions + ')';
        }

        public final String getDescription() {
            return this.description;
        }

        public final List<String> getPermissions() {
            return this.permissions;
        }

        public PermissionItem(String r2, List<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "description");
            Intrinsics.checkNotNullParameter(r3, "permissions");
            super(null);
            this.description = r2;
            this.permissions = r3;
        }
    }

    /* JADX INFO: compiled from: OPrivacySheetConfig.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/privacy/PrivacyItem$SwitchItem;", "Lcom/obric/oui/privacy/PrivacyItem;", "title", "", "subtitle", "isChecked", "", "onCheckedChange", "Lkotlin/Function1;", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "()Z", "getOnCheckedChange", "()Lkotlin/jvm/functions/Function1;", "getSubtitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SwitchItem extends PrivacyItem {
        private final boolean isChecked;
        private final Function1<Boolean, Unit> onCheckedChange;
        private final String subtitle;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SwitchItem copy$default(SwitchItem r0, String r1, String r2, boolean r3, Function1 r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.title;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.subtitle;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.isChecked;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.onCheckedChange;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.subtitle;
        }

        public final boolean component3() {
            return this.isChecked;
        }

        public final Function1<Boolean, Unit> component4() {
            return this.onCheckedChange;
        }

        public final SwitchItem copy(String r1, String r2, boolean r3, Function1<? super Boolean, Unit> r4) {
            Intrinsics.checkNotNullParameter(r1, "title");
            return new SwitchItem(r1, r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SwitchItem) == true) goto L8;
            return false;
        L8:
            SwitchItem r6 = (SwitchItem) r5;
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.subtitle, r6.subtitle) == true) goto L15;
            return false;
        L15:
            if (this.isChecked == r6.isChecked) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.onCheckedChange, r6.onCheckedChange) == true) goto L20;
            return false;
        L20:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public int hashCode() {
            int r0 = this.title.hashCode() * 31;
            String r1 = this.subtitle;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            boolean r5 = this.isChecked;
            ?? r6 = r5;
            if (r5 == false) goto L9;
            r6 = 1;
        L9:
            int r7 = (r4 + r6) * 31;
            Function1<Boolean, Unit> r8 = this.onCheckedChange;
            if (r8 == null) goto L14;
            r2 = r8.hashCode();
        L14:
            return r7 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "SwitchItem(title=" + this.title + ", subtitle=" + this.subtitle + ", isChecked=" + this.isChecked + ", onCheckedChange=" + this.onCheckedChange + ')';
        }

        public /* synthetic */ SwitchItem(String r2, String r3, boolean r4, Function1 r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = false;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r5 = null;
        L11:
            this(r2, r3, r4, r5);
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final boolean isChecked() {
            return this.isChecked;
        }

        public final Function1<Boolean, Unit> getOnCheckedChange() {
            return this.onCheckedChange;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SwitchItem(String r2, String r3, boolean r4, Function1<? super Boolean, Unit> r5) {
            Intrinsics.checkNotNullParameter(r2, "title");
            super(null);
            this.title = r2;
            this.subtitle = r3;
            this.isChecked = r4;
            this.onCheckedChange = r5;
        }
    }

    public /* synthetic */ PrivacyItem(DefaultConstructorMarker r1) {
        this();
    }

    private PrivacyItem() {
    }
}
