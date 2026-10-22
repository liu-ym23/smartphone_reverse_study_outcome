package com.uxsense.ruleTrigger;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.aiengine.args.ExecutionBundle;
import com.uxsense.core.model.ViewTrigger;
import com.uxsense.core.pattern.ParentFilter;
import com.uxsense.core.pattern.ViewPattern;
import com.uxsense.ruleTrigger.model.TriggerCondition;
import com.uxsense.ruleTrigger.model.ViewPatternSerializer;

/* loaded from: classes3.dex */
public class TriggerRule implements Parcelable {
    public static final Parcelable.Creator<TriggerRule> CREATOR = new Parcelable.Creator<TriggerRule>() { // from class: com.uxsense.ruleTrigger.TriggerRule.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TriggerRule createFromParcel(Parcel parcel) {
            return new TriggerRule(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TriggerRule[] newArray(int i) {
            return new TriggerRule[i];
        }
    };

    @Nullable
    private String activityClass;
    private String description;
    private boolean enabled;
    private String name;
    private String packageName;

    @Nullable
    private ParentFilter parentFilter;

    @NonNull
    private String source;
    private TriggerCondition trigger;

    @Nullable
    private ViewPattern viewPattern;

    @Nullable
    private String windowTitle;

    public static class Builder {
        private final String packageName;
        private String name = "";
        private String description = "";
        private String activityClass = null;
        private String windowTitle = null;
        private ViewPattern viewPattern = null;
        private ParentFilter parentFilter = null;
        private TriggerCondition trigger = new TriggerCondition();
        private boolean enabled = true;
        private String source = ExecutionBundle.PREF_LOCAL;

        public Builder(@NonNull String str) {
            this.packageName = str;
        }

        public Builder activityClass(@Nullable String str) {
            this.activityClass = str;
            return this;
        }

        public TriggerRule build() {
            return new TriggerRule(this.name, this.description, this.packageName, this.activityClass, this.windowTitle, this.viewPattern, this.parentFilter, this.trigger, this.enabled, this.source);
        }

        public Builder description(@NonNull String str) {
            this.description = str;
            return this;
        }

        public Builder enabled(boolean z10) {
            this.enabled = z10;
            return this;
        }

        public Builder name(@NonNull String str) {
            this.name = str;
            return this;
        }

        public Builder parentFilter(@Nullable ParentFilter parentFilter) {
            this.parentFilter = parentFilter;
            return this;
        }

        public Builder source(@NonNull String str) {
            this.source = str;
            return this;
        }

        public Builder trigger(@NonNull TriggerCondition triggerCondition) {
            this.trigger = triggerCondition;
            return this;
        }

        public Builder viewPattern(@Nullable ViewPattern viewPattern) {
            this.viewPattern = viewPattern;
            return this;
        }

        public Builder windowTitle(@Nullable String str) {
            this.windowTitle = str;
            return this;
        }
    }

    public TriggerRule() {
        this.name = "";
        this.description = "";
        this.packageName = "";
        this.activityClass = null;
        this.windowTitle = null;
        this.viewPattern = null;
        this.parentFilter = null;
        this.trigger = new TriggerCondition();
        this.enabled = true;
        this.source = ExecutionBundle.PREF_LOCAL;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getActivityClass() {
        return this.activityClass;
    }

    @NonNull
    public String getDescription() {
        return this.description;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @NonNull
    public String getPackageName() {
        return this.packageName;
    }

    @Nullable
    public ParentFilter getParentFilter() {
        return this.parentFilter;
    }

    @NonNull
    public String getSource() {
        return this.source;
    }

    @NonNull
    public TriggerCondition getTrigger() {
        return this.trigger;
    }

    @Nullable
    public ViewPattern getViewPattern() {
        return this.viewPattern;
    }

    @Nullable
    public String getWindowTitle() {
        return this.windowTitle;
    }

    public boolean hasActivityTrigger() {
        return this.trigger.hasActivityTriggers();
    }

    public boolean hasViewTrigger() {
        return this.viewPattern != null && this.trigger.hasViewTriggers();
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean matchesActivity(@androidx.annotation.NonNull java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r7 = r7.activityClass
            r0 = 1
            if (r7 != 0) goto L6
            return r0
        L6:
            boolean r1 = r7.equals(r8)
            if (r1 == 0) goto Ld
            return r0
        Ld:
            java.lang.String r1 = "/"
            boolean r2 = r8.contains(r1)
            r3 = 0
            r4 = 2
            java.lang.String r5 = "."
            if (r2 == 0) goto L33
            java.lang.String[] r2 = r8.split(r1, r4)
            int r6 = r2.length
            if (r6 != r4) goto L33
            r8 = r2[r0]
            boolean r6 = r8.startsWith(r5)
            if (r6 == 0) goto L33
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r2 = r2[r3]
            java.lang.String r8 = B7.a.q(r6, r2, r8)
        L33:
            boolean r2 = r7.contains(r1)
            if (r2 == 0) goto L4f
            java.lang.String[] r2 = r7.split(r1, r4)
            int r6 = r2.length
            if (r6 != r4) goto L4f
            r4 = r2[r3]
            r2 = r2[r0]
            boolean r6 = r2.startsWith(r5)
            if (r6 == 0) goto L50
            java.lang.String r2 = androidx.appfunctions.metadata.a.l(r4, r2)
            goto L50
        L4f:
            r2 = r7
        L50:
            boolean r2 = r2.equals(r8)
            if (r2 == 0) goto L57
            return r0
        L57:
            java.lang.String r2 = r5.concat(r7)
            boolean r2 = r8.endsWith(r2)
            if (r2 != 0) goto L8e
            java.lang.String r2 = r1.concat(r7)
            boolean r2 = r8.endsWith(r2)
            if (r2 == 0) goto L6c
            goto L8e
        L6c:
            boolean r2 = r7.contains(r5)
            if (r2 != 0) goto L8d
            boolean r2 = r7.contains(r1)
            if (r2 != 0) goto L8d
            java.lang.String r2 = r5.concat(r7)
            boolean r2 = r8.endsWith(r2)
            if (r2 != 0) goto L8c
            java.lang.String r7 = r1.concat(r7)
            boolean r7 = r8.endsWith(r7)
            if (r7 == 0) goto L8d
        L8c:
            return r0
        L8d:
            return r3
        L8e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ruleTrigger.TriggerRule.matchesActivity(java.lang.String):boolean");
    }

    public boolean requiresViewMatching() {
        return this.viewPattern != null;
    }

    public void setActivityClass(@Nullable String str) {
        this.activityClass = str;
    }

    public void setDescription(@NonNull String str) {
        if (str == null) {
            str = "";
        }
        this.description = str;
    }

    public void setEnabled(boolean z10) {
        this.enabled = z10;
    }

    public void setName(@NonNull String str) {
        if (str == null) {
            str = "";
        }
        this.name = str;
    }

    public void setPackageName(@NonNull String str) {
        if (str == null) {
            str = "";
        }
        this.packageName = str;
    }

    public void setParentFilter(@Nullable ParentFilter parentFilter) {
        this.parentFilter = parentFilter;
    }

    public void setSource(@NonNull String str) {
        if (str == null) {
            str = ExecutionBundle.PREF_LOCAL;
        }
        this.source = str;
    }

    public void setTrigger(@NonNull TriggerCondition triggerCondition) {
        if (triggerCondition == null) {
            triggerCondition = new TriggerCondition();
        }
        this.trigger = triggerCondition;
    }

    public void setViewPattern(@Nullable ViewPattern viewPattern) {
        this.viewPattern = viewPattern;
    }

    public void setWindowTitle(@Nullable String str) {
        this.windowTitle = str;
    }

    public boolean shouldTriggerOnActivity(int i) {
        if (this.trigger.hasActivityTriggers()) {
            return this.trigger.containsActivityTrigger(i);
        }
        return false;
    }

    public boolean shouldTriggerOnView(ViewTrigger viewTrigger) {
        if (this.trigger.hasViewTriggers()) {
            return this.trigger.containsViewTrigger(viewTrigger);
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TriggerRule{name='");
        sb.append(this.name);
        sb.append("', description='");
        sb.append(this.description);
        sb.append("', packageName='");
        sb.append(this.packageName);
        sb.append("', activityClass='");
        sb.append(this.activityClass);
        sb.append("', windowTitle='");
        sb.append(this.windowTitle);
        sb.append("', viewPattern=");
        sb.append(this.viewPattern);
        sb.append(", parentFilter=");
        sb.append(this.parentFilter);
        sb.append(", trigger=");
        sb.append(this.trigger);
        sb.append(", enabled=");
        sb.append(this.enabled);
        sb.append(", source='");
        return B7.a.q(sb, this.source, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.packageName);
        parcel.writeString(this.activityClass);
        parcel.writeString(this.windowTitle);
        parcel.writeString(ViewPatternSerializer.serializeViewPattern(this.viewPattern));
        parcel.writeString(ViewPatternSerializer.serializeParentFilter(this.parentFilter));
        parcel.writeParcelable(this.trigger, i);
        parcel.writeByte(this.enabled ? (byte) 1 : (byte) 0);
        parcel.writeString(this.source);
    }

    public TriggerRule(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5, @Nullable ViewPattern viewPattern, @Nullable ParentFilter parentFilter, @NonNull TriggerCondition triggerCondition, boolean z10) {
        this(str, str2, str3, str4, str5, viewPattern, parentFilter, triggerCondition, z10, ExecutionBundle.PREF_LOCAL);
    }

    public TriggerRule(@NonNull String str, @NonNull String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5, @Nullable ViewPattern viewPattern, @Nullable ParentFilter parentFilter, @NonNull TriggerCondition triggerCondition, boolean z10, @NonNull String str6) {
        this.name = str == null ? "" : str;
        this.description = str2 == null ? "" : str2;
        this.packageName = str3 == null ? "" : str3;
        this.activityClass = str4;
        this.windowTitle = str5;
        this.viewPattern = viewPattern;
        this.parentFilter = parentFilter;
        this.trigger = triggerCondition == null ? new TriggerCondition() : triggerCondition;
        this.enabled = z10;
        this.source = str6 == null ? ExecutionBundle.PREF_LOCAL : str6;
    }

    public TriggerRule(Parcel parcel) {
        this.name = parcel.readString();
        this.description = parcel.readString();
        this.packageName = parcel.readString();
        this.activityClass = parcel.readString();
        this.windowTitle = parcel.readString();
        this.viewPattern = ViewPatternSerializer.deserializeViewPattern(parcel.readString());
        this.parentFilter = ViewPatternSerializer.deserializeParentFilter(parcel.readString());
        this.trigger = (TriggerCondition) parcel.readParcelable(TriggerCondition.class.getClassLoader());
        this.enabled = parcel.readByte() != 0;
        String string = parcel.readString();
        this.source = string == null ? ExecutionBundle.PREF_LOCAL : string;
    }
}
