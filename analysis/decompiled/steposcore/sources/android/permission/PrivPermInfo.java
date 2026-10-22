package android.permission;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PrivPermInfo implements Parcelable {
    public static final Parcelable.Creator<PrivPermInfo> CREATOR = new Parcelable.Creator<PrivPermInfo>() { // from class: android.permission.PrivPermInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivPermInfo createFromParcel(Parcel parcel) {
            String pkg = parcel.readString();
            int type = parcel.readInt();
            String[] time = parcel.readStringArray();
            ArrayList<String> times = new ArrayList<>();
            for (String str : time) {
                times.add(str);
            }
            return new PrivPermInfo(pkg, type, times);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivPermInfo[] newArray(int i) {
            return new PrivPermInfo[i];
        }
    };
    private String pkg;
    private ArrayList<String> times;
    private int type;

    public PrivPermInfo(String pkg, int type, ArrayList<String> times) {
        this.pkg = pkg;
        this.type = type;
        this.times = times;
    }

    public String getPkg() {
        return this.pkg;
    }

    public void setPkg(String pkg) {
        this.pkg = pkg;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<String> getTimes() {
        return this.times;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pkg);
        parcel.writeInt(this.type);
        String[] s = new String[this.times.size()];
        for (int j = 0; j < this.times.size(); j++) {
            s[j] = this.times.get(j);
        }
        parcel.writeStringArray(s);
    }
}
