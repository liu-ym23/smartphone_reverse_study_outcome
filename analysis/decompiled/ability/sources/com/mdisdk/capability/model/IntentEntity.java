package com.mdisdk.capability.model;

import B7.a;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class IntentEntity implements Parcelable {
    public static final Parcelable.Creator<IntentEntity> CREATOR = new Parcelable.Creator<IntentEntity>() { // from class: com.mdisdk.capability.model.IntentEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentEntity createFromParcel(Parcel parcel) {
            return new IntentEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IntentEntity[] newArray(int i) {
            return new IntentEntity[i];
        }
    };
    private static final String TAG = "IntentEntity";
    private final String activityClassName;
    private final String componentName;
    private final String intentAction;
    private final String intentCategories;
    private final String intentDataUri;
    private final String intentExtras;
    private final String intentFlags;
    private final String intentType;
    private final String packageName;

    public IntentEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.componentName = str == null ? "" : str;
        this.packageName = str2 == null ? "" : str2;
        this.activityClassName = str3 == null ? "" : str3;
        this.intentAction = str4;
        this.intentDataUri = str5;
        this.intentType = str6;
        this.intentCategories = str7;
        this.intentFlags = str8;
        this.intentExtras = str9;
    }

    @NonNull
    private static List<String> deserializeCategories(@Nullable String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            } catch (JSONException unused) {
                Log.w(TAG, "Failed to parse categories JSON: ".concat(str));
            }
        }
        return arrayList;
    }

    @Nullable
    private static Bundle deserializeExtras(@Nullable String str) {
        if (str != null && !str.isEmpty()) {
            try {
                byte[] bArrDecode = Base64.decode(str, 2);
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
                parcelObtain.setDataPosition(0);
                Bundle bundle = parcelObtain.readBundle(IntentEntity.class.getClassLoader());
                parcelObtain.recycle();
                return bundle;
            } catch (Exception e) {
                Log.w(TAG, "Failed to deserialize extras: " + e.getMessage());
            }
        }
        return null;
    }

    @NonNull
    public static IntentEntity fromIntent(@Nullable Intent intent) {
        String str;
        String str2;
        String className;
        String packageName;
        if (intent == null) {
            return new IntentEntity("", "", "", null, null, null, null, null, null);
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            String strFlattenToString = component.flattenToString();
            packageName = component.getPackageName();
            className = component.getClassName();
            str = strFlattenToString;
        } else {
            if (intent.getPackage() == null) {
                str = "";
                str2 = str;
                className = str2;
                return new IntentEntity(str, str2, className, intent.getAction(), intent.getDataString(), intent.getType(), serializeCategories(intent.getCategories()), Integer.toHexString(intent.getFlags()), serializeExtras(intent.getExtras()));
            }
            packageName = intent.getPackage();
            str = "";
            className = str;
        }
        str2 = packageName;
        return new IntentEntity(str, str2, className, intent.getAction(), intent.getDataString(), intent.getType(), serializeCategories(intent.getCategories()), Integer.toHexString(intent.getFlags()), serializeExtras(intent.getExtras()));
    }

    @Nullable
    private static String serializeCategories(@Nullable Set<String> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray.toString();
    }

    @Nullable
    private static String serializeExtras(@Nullable Bundle bundle) {
        if (bundle != null && !bundle.isEmpty()) {
            try {
                Parcel parcelObtain = Parcel.obtain();
                bundle.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                return Base64.encodeToString(bArrMarshall, 2);
            } catch (Exception e) {
                Log.w(TAG, "Failed to serialize extras: " + e.getMessage());
            }
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            IntentEntity intentEntity = (IntentEntity) obj;
            if (this.componentName.equals(intentEntity.componentName) && this.packageName.equals(intentEntity.packageName) && this.activityClassName.equals(intentEntity.activityClassName)) {
                return true;
            }
        }
        return false;
    }

    public String getActivityClassName() {
        return this.activityClassName;
    }

    public String getComponentName() {
        return this.componentName;
    }

    @Nullable
    public String getIntentAction() {
        return this.intentAction;
    }

    @Nullable
    public String getIntentCategories() {
        return this.intentCategories;
    }

    @Nullable
    public String getIntentDataUri() {
        return this.intentDataUri;
    }

    @Nullable
    public String getIntentExtras() {
        return this.intentExtras;
    }

    @Nullable
    public String getIntentFlags() {
        return this.intentFlags;
    }

    @Nullable
    public String getIntentType() {
        return this.intentType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.activityClassName.hashCode() + a.c(this.componentName.hashCode() * 31, 31, this.packageName);
    }

    @NonNull
    public Intent toIntent() {
        String str;
        Bundle bundleDeserializeExtras;
        String str2;
        Intent intent = new Intent();
        String str3 = this.intentAction;
        if (str3 != null && !str3.isEmpty()) {
            intent.setAction(this.intentAction);
        }
        String str4 = this.componentName;
        if (str4 == null || str4.isEmpty()) {
            String str5 = this.packageName;
            if (str5 != null && !str5.isEmpty() && (str = this.activityClassName) != null && !str.isEmpty()) {
                intent.setComponent(new ComponentName(this.packageName, this.activityClassName));
            }
        } else {
            ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(this.componentName);
            if (componentNameUnflattenFromString != null) {
                intent.setComponent(componentNameUnflattenFromString);
            }
        }
        String str6 = this.intentDataUri;
        Uri uri = (str6 == null || str6.isEmpty()) ? null : Uri.parse(this.intentDataUri);
        if (uri != null && (str2 = this.intentType) != null && !str2.isEmpty()) {
            intent.setDataAndType(uri, this.intentType);
        } else if (uri != null) {
            intent.setData(uri);
        } else {
            String str7 = this.intentType;
            if (str7 != null && !str7.isEmpty()) {
                intent.setType(this.intentType);
            }
        }
        String str8 = this.intentCategories;
        if (str8 != null && !str8.isEmpty()) {
            Iterator<String> it = deserializeCategories(this.intentCategories).iterator();
            while (it.hasNext()) {
                intent.addCategory(it.next());
            }
        }
        String str9 = this.intentFlags;
        if (str9 != null && !str9.isEmpty()) {
            try {
                intent.setFlags(Integer.parseInt(this.intentFlags, 16));
            } catch (NumberFormatException unused) {
                Log.w(TAG, "Failed to parse intent flags: " + this.intentFlags);
            }
        }
        String str10 = this.intentExtras;
        if (str10 != null && !str10.isEmpty() && (bundleDeserializeExtras = deserializeExtras(this.intentExtras)) != null) {
            intent.putExtras(bundleDeserializeExtras);
        }
        return intent;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IntentEntity{componentName='");
        sb.append(this.componentName);
        sb.append("', packageName='");
        sb.append(this.packageName);
        sb.append("', activityClassName='");
        sb.append(this.activityClassName);
        sb.append("', intentAction='");
        sb.append(this.intentAction);
        sb.append("', intentDataUri='");
        sb.append(this.intentDataUri);
        sb.append("', intentType='");
        sb.append(this.intentType);
        sb.append("', intentCategories='");
        sb.append(this.intentCategories);
        sb.append("', intentFlags='");
        sb.append(this.intentFlags);
        sb.append("', intentExtras='");
        return a.q(sb, this.intentExtras != null ? "[Base64]" : "null", "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.componentName);
        parcel.writeString(this.packageName);
        parcel.writeString(this.activityClassName);
        parcel.writeString(this.intentAction);
        parcel.writeString(this.intentDataUri);
        parcel.writeString(this.intentType);
        parcel.writeString(this.intentCategories);
        parcel.writeString(this.intentFlags);
        parcel.writeString(this.intentExtras);
    }

    public IntentEntity(Parcel parcel) {
        this.componentName = parcel.readString();
        this.packageName = parcel.readString();
        this.activityClassName = parcel.readString();
        this.intentAction = parcel.readString();
        this.intentDataUri = parcel.readString();
        this.intentType = parcel.readString();
        this.intentCategories = parcel.readString();
        this.intentFlags = parcel.readString();
        this.intentExtras = parcel.readString();
    }
}
