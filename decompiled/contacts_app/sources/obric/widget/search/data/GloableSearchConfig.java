package obric.widget.search.data;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class GloableSearchConfig implements Parcelable {
    public static final Parcelable.Creator<GloableSearchConfig> CREATOR = null;
    public static final String KEY_CONFIGS = "types";
    public static final String KEY_VERSION = "version";
    private int id;
    private List<SearchConfigType> mConfigTypes;
    private int mVersion;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* synthetic */ GloableSearchConfig(Parcel r1, AnonymousClass1 r2) {
        this(r1);
    }

    public GloableSearchConfig() {
    }

    public int getVersion() {
        return this.mVersion;
    }

    public void setVersion(int version) {
        this.mVersion = version;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SearchConfigType> getConfigTypes() {
        return this.mConfigTypes;
    }

    public boolean isValid() {
        List<SearchConfigType> r2 = this.mConfigTypes;
        if (r2 != null) goto L5;
        return false;
    L5:
        Iterator<SearchConfigType> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L12;
        if (r3.next().hasDatas() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public void updateDefaultTypes(Context context) {
        List<SearchConfigType> r2 = this.mConfigTypes;
        if (r2 != null) goto L5;
        return;
    L5:
        Iterator<SearchConfigType> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        SearchConfigType r0 = r3.next();
        r0.updateDefaultData(SearchConfigTypeHelper.getDefaultType(context, r0.getType()));
        goto L7
    }

    public void setConfigTypes(List<SearchConfigType> configs) {
        this.mConfigTypes = configs;
        if (configs == null) goto L6;
        Collections.sort(configs, new AnonymousClass1(this));
        return;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        if (this.mConfigTypes == null) goto L9;
        Iterator<SearchConfigType> r1 = getConfigTypes().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        r0.append(r1.next().toString() + "\n");
    L9:
        return String.format("{version:%s,configs[\n%s]}", new Object[]{Integer.valueOf(this.mVersion), r0});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.id);
        out.writeInt(this.mVersion);
        out.writeTypedList(this.mConfigTypes);
    }

    private GloableSearchConfig(Parcel in) {
        this.id = in.readInt();
        this.mVersion = in.readInt();
        if (this.mConfigTypes != null) goto L5;
        this.mConfigTypes = new ArrayList();
    L5:
        in.readTypedList(this.mConfigTypes, SearchConfigType.CREATOR);
    }

    static {
        CREATOR = new AnonymousClass2();
    }
}
