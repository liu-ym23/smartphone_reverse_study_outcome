package android.hardware.broadcastradio;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = null;
    public static final int albumArt = 8;
    public static final int commentActualText = 18;
    public static final int commentShortDescription = 17;
    public static final int commercial = 19;
    public static final int dabComponentName = 14;
    public static final int dabComponentNameShort = 15;
    public static final int dabEnsembleName = 10;
    public static final int dabEnsembleNameShort = 11;
    public static final int dabServiceName = 12;
    public static final int dabServiceNameShort = 13;
    public static final int genre = 16;
    public static final int hdStationNameLong = 22;
    public static final int hdStationNameShort = 21;
    public static final int hdSubChannelsAvailable = 23;
    public static final int programName = 9;
    public static final int rbdsPty = 2;
    public static final int rdsPs = 0;
    public static final int rdsPty = 1;
    public static final int rdsRt = 3;
    public static final int songAlbum = 6;
    public static final int songArtist = 5;
    public static final int songTitle = 4;
    public static final int stationIcon = 7;
    public static final int ufids = 20;
    private int _tag;
    private Object _value;

    public @interface Tag {
        public static final int albumArt = 8;
        public static final int commentActualText = 18;
        public static final int commentShortDescription = 17;
        public static final int commercial = 19;
        public static final int dabComponentName = 14;
        public static final int dabComponentNameShort = 15;
        public static final int dabEnsembleName = 10;
        public static final int dabEnsembleNameShort = 11;
        public static final int dabServiceName = 12;
        public static final int dabServiceNameShort = 13;
        public static final int genre = 16;
        public static final int hdStationNameLong = 22;
        public static final int hdStationNameShort = 21;
        public static final int hdSubChannelsAvailable = 23;
        public static final int programName = 9;
        public static final int rbdsPty = 2;
        public static final int rdsPs = 0;
        public static final int rdsPty = 1;
        public static final int rdsRt = 3;
        public static final int songAlbum = 6;
        public static final int songArtist = 5;
        public static final int songTitle = 4;
        public static final int stationIcon = 7;
        public static final int ufids = 20;
    }

    /* synthetic */ Metadata(Parcel r1, MetadataIA r2) {
        this(r1);
    }

    public Metadata() {
        this._tag = 0;
        this._value = null;
    }

    private Metadata(Parcel _aidl_parcel) {
        readFromParcel(_aidl_parcel);
    }

    private Metadata(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }

    public int getTag() {
        return this._tag;
    }

    public static Metadata rdsPs(String _value) {
        return new Metadata(0, _value);
    }

    public String getRdsPs() {
        _assertTag(0);
        return (String) this._value;
    }

    public void setRdsPs(String _value) {
        _set(0, _value);
    }

    public static Metadata rdsPty(int _value) {
        return new Metadata(1, Integer.valueOf(_value));
    }

    public int getRdsPty() {
        _assertTag(1);
        return ((Integer) this._value).intValue();
    }

    public void setRdsPty(int _value) {
        _set(1, Integer.valueOf(_value));
    }

    public static Metadata rbdsPty(int _value) {
        return new Metadata(2, Integer.valueOf(_value));
    }

    public int getRbdsPty() {
        _assertTag(2);
        return ((Integer) this._value).intValue();
    }

    public void setRbdsPty(int _value) {
        _set(2, Integer.valueOf(_value));
    }

    public static Metadata rdsRt(String _value) {
        return new Metadata(3, _value);
    }

    public String getRdsRt() {
        _assertTag(3);
        return (String) this._value;
    }

    public void setRdsRt(String _value) {
        _set(3, _value);
    }

    public static Metadata songTitle(String _value) {
        return new Metadata(4, _value);
    }

    public String getSongTitle() {
        _assertTag(4);
        return (String) this._value;
    }

    public void setSongTitle(String _value) {
        _set(4, _value);
    }

    public static Metadata songArtist(String _value) {
        return new Metadata(5, _value);
    }

    public String getSongArtist() {
        _assertTag(5);
        return (String) this._value;
    }

    public void setSongArtist(String _value) {
        _set(5, _value);
    }

    public static Metadata songAlbum(String _value) {
        return new Metadata(6, _value);
    }

    public String getSongAlbum() {
        _assertTag(6);
        return (String) this._value;
    }

    public void setSongAlbum(String _value) {
        _set(6, _value);
    }

    public static Metadata stationIcon(int _value) {
        return new Metadata(7, Integer.valueOf(_value));
    }

    public int getStationIcon() {
        _assertTag(7);
        return ((Integer) this._value).intValue();
    }

    public void setStationIcon(int _value) {
        _set(7, Integer.valueOf(_value));
    }

    public static Metadata albumArt(int _value) {
        return new Metadata(8, Integer.valueOf(_value));
    }

    public int getAlbumArt() {
        _assertTag(8);
        return ((Integer) this._value).intValue();
    }

    public void setAlbumArt(int _value) {
        _set(8, Integer.valueOf(_value));
    }

    public static Metadata programName(String _value) {
        return new Metadata(9, _value);
    }

    public String getProgramName() {
        _assertTag(9);
        return (String) this._value;
    }

    public void setProgramName(String _value) {
        _set(9, _value);
    }

    public static Metadata dabEnsembleName(String _value) {
        return new Metadata(10, _value);
    }

    public String getDabEnsembleName() {
        _assertTag(10);
        return (String) this._value;
    }

    public void setDabEnsembleName(String _value) {
        _set(10, _value);
    }

    public static Metadata dabEnsembleNameShort(String _value) {
        return new Metadata(11, _value);
    }

    public String getDabEnsembleNameShort() {
        _assertTag(11);
        return (String) this._value;
    }

    public void setDabEnsembleNameShort(String _value) {
        _set(11, _value);
    }

    public static Metadata dabServiceName(String _value) {
        return new Metadata(12, _value);
    }

    public String getDabServiceName() {
        _assertTag(12);
        return (String) this._value;
    }

    public void setDabServiceName(String _value) {
        _set(12, _value);
    }

    public static Metadata dabServiceNameShort(String _value) {
        return new Metadata(13, _value);
    }

    public String getDabServiceNameShort() {
        _assertTag(13);
        return (String) this._value;
    }

    public void setDabServiceNameShort(String _value) {
        _set(13, _value);
    }

    public static Metadata dabComponentName(String _value) {
        return new Metadata(14, _value);
    }

    public String getDabComponentName() {
        _assertTag(14);
        return (String) this._value;
    }

    public void setDabComponentName(String _value) {
        _set(14, _value);
    }

    public static Metadata dabComponentNameShort(String _value) {
        return new Metadata(15, _value);
    }

    public String getDabComponentNameShort() {
        _assertTag(15);
        return (String) this._value;
    }

    public void setDabComponentNameShort(String _value) {
        _set(15, _value);
    }

    public static Metadata genre(String _value) {
        return new Metadata(16, _value);
    }

    public String getGenre() {
        _assertTag(16);
        return (String) this._value;
    }

    public void setGenre(String _value) {
        _set(16, _value);
    }

    public static Metadata commentShortDescription(String _value) {
        return new Metadata(17, _value);
    }

    public String getCommentShortDescription() {
        _assertTag(17);
        return (String) this._value;
    }

    public void setCommentShortDescription(String _value) {
        _set(17, _value);
    }

    public static Metadata commentActualText(String _value) {
        return new Metadata(18, _value);
    }

    public String getCommentActualText() {
        _assertTag(18);
        return (String) this._value;
    }

    public void setCommentActualText(String _value) {
        _set(18, _value);
    }

    public static Metadata commercial(String _value) {
        return new Metadata(19, _value);
    }

    public String getCommercial() {
        _assertTag(19);
        return (String) this._value;
    }

    public void setCommercial(String _value) {
        _set(19, _value);
    }

    public static Metadata ufids(String[] _value) {
        return new Metadata(20, _value);
    }

    public String[] getUfids() {
        _assertTag(20);
        return (String[]) this._value;
    }

    public void setUfids(String[] _value) {
        _set(20, _value);
    }

    public static Metadata hdStationNameShort(String _value) {
        return new Metadata(21, _value);
    }

    public String getHdStationNameShort() {
        _assertTag(21);
        return (String) this._value;
    }

    public void setHdStationNameShort(String _value) {
        _set(21, _value);
    }

    public static Metadata hdStationNameLong(String _value) {
        return new Metadata(22, _value);
    }

    public String getHdStationNameLong() {
        _assertTag(22);
        return (String) this._value;
    }

    public void setHdStationNameLong(String _value) {
        _set(22, _value);
    }

    public static Metadata hdSubChannelsAvailable(int _value) {
        return new Metadata(23, Integer.valueOf(_value));
    }

    public int getHdSubChannelsAvailable() {
        _assertTag(23);
        return ((Integer) this._value).intValue();
    }

    public void setHdSubChannelsAvailable(int _value) {
        _set(23, Integer.valueOf(_value));
    }

    public final int getStability() {
        return 1;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel _aidl_parcel, int _aidl_flag) {
        _aidl_parcel.writeInt(this._tag);
        switch(this._tag) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L11;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L8;
            case 21: goto L7;
            case 22: goto L6;
            case 23: goto L5;
            default: goto L53;
        };
    L5:
        _aidl_parcel.writeInt(getHdSubChannelsAvailable());
        return;
    L6:
        _aidl_parcel.writeString(getHdStationNameLong());
        return;
    L7:
        _aidl_parcel.writeString(getHdStationNameShort());
        return;
    L8:
        _aidl_parcel.writeStringArray(getUfids());
        return;
    L9:
        _aidl_parcel.writeString(getCommercial());
        return;
    L10:
        _aidl_parcel.writeString(getCommentActualText());
        return;
    L11:
        _aidl_parcel.writeString(getCommentShortDescription());
        return;
    L12:
        _aidl_parcel.writeString(getGenre());
        return;
    L13:
        _aidl_parcel.writeString(getDabComponentNameShort());
        return;
    L14:
        _aidl_parcel.writeString(getDabComponentName());
        return;
    L15:
        _aidl_parcel.writeString(getDabServiceNameShort());
        return;
    L16:
        _aidl_parcel.writeString(getDabServiceName());
        return;
    L17:
        _aidl_parcel.writeString(getDabEnsembleNameShort());
        return;
    L18:
        _aidl_parcel.writeString(getDabEnsembleName());
        return;
    L19:
        _aidl_parcel.writeString(getProgramName());
        return;
    L20:
        _aidl_parcel.writeInt(getAlbumArt());
        return;
    L21:
        _aidl_parcel.writeInt(getStationIcon());
        return;
    L22:
        _aidl_parcel.writeString(getSongAlbum());
        return;
    L23:
        _aidl_parcel.writeString(getSongArtist());
        return;
    L24:
        _aidl_parcel.writeString(getSongTitle());
        return;
    L25:
        _aidl_parcel.writeString(getRdsRt());
        return;
    L26:
        _aidl_parcel.writeInt(getRbdsPty());
        return;
    L27:
        _aidl_parcel.writeInt(getRdsPty());
        return;
    L28:
        _aidl_parcel.writeString(getRdsPs());
        return;
    }

    public void readFromParcel(Parcel _aidl_parcel) {
        int _aidl_tag = _aidl_parcel.readInt();
        switch(_aidl_tag) {
            case 0: goto L52;
            case 1: goto L50;
            case 2: goto L48;
            case 3: goto L46;
            case 4: goto L44;
            case 5: goto L42;
            case 6: goto L40;
            case 7: goto L38;
            case 8: goto L36;
            case 9: goto L34;
            case 10: goto L32;
            case 11: goto L30;
            case 12: goto L28;
            case 13: goto L26;
            case 14: goto L24;
            case 15: goto L22;
            case 16: goto L20;
            case 17: goto L18;
            case 18: goto L16;
            case 19: goto L14;
            case 20: goto L12;
            case 21: goto L10;
            case 22: goto L8;
            case 23: goto L6;
            default: goto L5;
        };
    L6:
        int _aidl_value = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value));
        return;
    L8:
        String _aidl_value2 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value2);
        return;
    L10:
        String _aidl_value3 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value3);
        return;
    L12:
        String[] _aidl_value4 = _aidl_parcel.createStringArray();
        _set(_aidl_tag, _aidl_value4);
        return;
    L14:
        String _aidl_value5 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value5);
        return;
    L16:
        String _aidl_value6 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value6);
        return;
    L18:
        String _aidl_value7 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value7);
        return;
    L20:
        String _aidl_value8 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value8);
        return;
    L22:
        String _aidl_value9 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value9);
        return;
    L24:
        String _aidl_value10 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value10);
        return;
    L26:
        String _aidl_value11 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value11);
        return;
    L28:
        String _aidl_value12 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value12);
        return;
    L30:
        String _aidl_value13 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value13);
        return;
    L32:
        String _aidl_value14 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value14);
        return;
    L34:
        String _aidl_value15 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value15);
        return;
    L36:
        int _aidl_value16 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value16));
        return;
    L38:
        int _aidl_value17 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value17));
        return;
    L40:
        String _aidl_value18 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value18);
        return;
    L42:
        String _aidl_value19 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value19);
        return;
    L44:
        String _aidl_value20 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value20);
        return;
    L46:
        String _aidl_value21 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value21);
        return;
    L48:
        int _aidl_value22 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value22));
        return;
    L50:
        int _aidl_value23 = _aidl_parcel.readInt();
        _set(_aidl_tag, Integer.valueOf(_aidl_value23));
        return;
    L52:
        String _aidl_value24 = _aidl_parcel.readString();
        _set(_aidl_tag, _aidl_value24);
        return;
    L5:
        throw new IllegalArgumentException("union: unknown tag: " + _aidl_tag);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        getTag();
        return 0;
    }

    public String toString() {
        switch(this._tag) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L37;
            case 9: goto L35;
            case 10: goto L33;
            case 11: goto L31;
            case 12: goto L29;
            case 13: goto L27;
            case 14: goto L25;
            case 15: goto L23;
            case 16: goto L21;
            case 17: goto L19;
            case 18: goto L17;
            case 19: goto L15;
            case 20: goto L13;
            case 21: goto L11;
            case 22: goto L9;
            case 23: goto L7;
            default: goto L5;
        };
    L5:
        throw new IllegalStateException("unknown field: " + this._tag);
    L7:
        return "Metadata.hdSubChannelsAvailable(" + getHdSubChannelsAvailable() + ")";
    L9:
        return "Metadata.hdStationNameLong(" + Objects.toString(getHdStationNameLong()) + ")";
    L11:
        return "Metadata.hdStationNameShort(" + Objects.toString(getHdStationNameShort()) + ")";
    L13:
        return "Metadata.ufids(" + Arrays.toString(getUfids()) + ")";
    L15:
        return "Metadata.commercial(" + Objects.toString(getCommercial()) + ")";
    L17:
        return "Metadata.commentActualText(" + Objects.toString(getCommentActualText()) + ")";
    L19:
        return "Metadata.commentShortDescription(" + Objects.toString(getCommentShortDescription()) + ")";
    L21:
        return "Metadata.genre(" + Objects.toString(getGenre()) + ")";
    L23:
        return "Metadata.dabComponentNameShort(" + Objects.toString(getDabComponentNameShort()) + ")";
    L25:
        return "Metadata.dabComponentName(" + Objects.toString(getDabComponentName()) + ")";
    L27:
        return "Metadata.dabServiceNameShort(" + Objects.toString(getDabServiceNameShort()) + ")";
    L29:
        return "Metadata.dabServiceName(" + Objects.toString(getDabServiceName()) + ")";
    L31:
        return "Metadata.dabEnsembleNameShort(" + Objects.toString(getDabEnsembleNameShort()) + ")";
    L33:
        return "Metadata.dabEnsembleName(" + Objects.toString(getDabEnsembleName()) + ")";
    L35:
        return "Metadata.programName(" + Objects.toString(getProgramName()) + ")";
    L37:
        return "Metadata.albumArt(" + getAlbumArt() + ")";
    L39:
        return "Metadata.stationIcon(" + getStationIcon() + ")";
    L41:
        return "Metadata.songAlbum(" + Objects.toString(getSongAlbum()) + ")";
    L43:
        return "Metadata.songArtist(" + Objects.toString(getSongArtist()) + ")";
    L45:
        return "Metadata.songTitle(" + Objects.toString(getSongTitle()) + ")";
    L47:
        return "Metadata.rdsRt(" + Objects.toString(getRdsRt()) + ")";
    L49:
        return "Metadata.rbdsPty(" + getRbdsPty() + ")";
    L51:
        return "Metadata.rdsPty(" + getRdsPty() + ")";
    L53:
        return "Metadata.rdsPs(" + Objects.toString(getRdsPs()) + ")";
    }

    public boolean equals(Object other) {
        if (this != other) goto L6;
        return true;
    L6:
        if (other != null) goto L9;
        return false;
    L9:
        if ((other instanceof Metadata) == true) goto L11;
        return false;
    L11:
        Metadata that = (Metadata) other;
        if (this._tag == that._tag) goto L15;
        return false;
    L15:
        if (Objects.deepEquals(this._value, that._value) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return Arrays.deepHashCode(Arrays.asList(new Object[]{Integer.valueOf(this._tag), this._value}).toArray());
    }

    private void _assertTag(int tag) {
        if (getTag() != tag) goto L6;
        return;
    L6:
        throw new IllegalStateException("bad access: " + _tagString(tag) + ", " + _tagString(getTag()) + " is available.");
    }

    private String _tagString(int _tag) {
        switch(_tag) {
            case 0: goto L51;
            case 1: goto L49;
            case 2: goto L47;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L41;
            case 6: goto L39;
            case 7: goto L37;
            case 8: goto L35;
            case 9: goto L33;
            case 10: goto L31;
            case 11: goto L29;
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L23;
            case 15: goto L21;
            case 16: goto L19;
            case 17: goto L17;
            case 18: goto L15;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            case 23: goto L5;
            default: goto L4;
        };
    L5:
        return "hdSubChannelsAvailable";
    L7:
        return "hdStationNameLong";
    L9:
        return "hdStationNameShort";
    L11:
        return "ufids";
    L13:
        return "commercial";
    L15:
        return "commentActualText";
    L17:
        return "commentShortDescription";
    L19:
        return "genre";
    L21:
        return "dabComponentNameShort";
    L23:
        return "dabComponentName";
    L25:
        return "dabServiceNameShort";
    L27:
        return "dabServiceName";
    L29:
        return "dabEnsembleNameShort";
    L31:
        return "dabEnsembleName";
    L33:
        return "programName";
    L35:
        return "albumArt";
    L37:
        return "stationIcon";
    L39:
        return "songAlbum";
    L41:
        return "songArtist";
    L43:
        return "songTitle";
    L45:
        return "rdsRt";
    L47:
        return "rbdsPty";
    L49:
        return "rdsPty";
    L51:
        return "rdsPs";
    L4:
        throw new IllegalStateException("unknown field: " + _tag);
    }

    private void _set(int _tag, Object _value) {
        this._tag = _tag;
        this._value = _value;
    }
}
