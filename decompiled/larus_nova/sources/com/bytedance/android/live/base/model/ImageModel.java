package com.bytedance.android.live.base.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class ImageModel extends FlexModelBase<py.k> implements Parcelable, py.k {
    public static final Parcelable.Creator<ImageModel> CREATOR = null;
    protected static final int HASH_CODE_31 = 31;

    @SerializedName("avg_color")
    public String avgColor;

    @SerializedName("content")
    protected Content content;

    @SerializedName("height")
    public int height;
    private String iconStub;

    @SerializedName("image_type")
    protected int imageType;

    @SerializedName("is_animated")
    protected boolean isAnimated;
    private boolean isFeedCandidate;
    private boolean isLoaded;
    private boolean isMonitored;
    public boolean isNinePatch;
    public boolean isResizableImg;

    @SerializedName("uri")
    public String mUri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    public List<String> mUrls;

    @SerializedName("open_web_url")
    public String schema;

    @SerializedName("width")
    public int width;

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class Content extends FlexModelBase<py.k.b> implements Parcelable, py.k.b {
        public static final Parcelable.Creator<Content> CREATOR = null;

        @SerializedName("alternative_text")
        String accessibilityText;

        @SerializedName("font_color")
        String fontColor;

        @SerializedName("level")
        long level;

        @SerializedName("name")
        String name;

        public class a implements Parcelable.Creator<Content> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Content createFromParcel(Parcel r100) {
                return new Content(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final Content[] newArray(int r100) {
                return new Content[r100];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public Content() {
            super(py.k.b.class);
        }

        @Override // py.k.b
        public String getAccessibilityText() {
            return this.accessibilityText;
        }

        @Override // py.k.b
        public String getFontColor() {
            return this.fontColor;
        }

        @Override // py.k.b
        public long getLevel() {
            return this.level;
        }

        @Override // py.k.b
        public String getName() {
            return this.name;
        }

        public Content(Parcel r100) {
            super(py.k.b.class);
            this.name = r100.readString();
            this.fontColor = r100.readString();
            this.level = r100.readLong();
            this.accessibilityText = r100.readString();
        }

        public static boolean isValid(Content r100) {
            if (r100 != null) goto L4;
        L8:
            return false;
        L4:
            if (TextUtils.isEmpty(r100.getName()) == true) goto L8;
            if (TextUtils.isEmpty(r100.getFontColor()) == true) goto L8;
            return true;
        }

        @Override // py.k.b
        public void setAccessibilityText(String r100) {
            this.accessibilityText = r100;
        }

        @Override // py.k.b
        public void setFontColor(String r100) {
            this.fontColor = r100;
        }

        @Override // py.k.b
        public void setLevel(long r100) {
            this.level = r100;
        }

        @Override // py.k.b
        public void setName(String r100) {
            this.name = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.name);
            r100.writeString(this.fontColor);
            r100.writeLong(this.level);
            r100.writeString(this.accessibilityText);
        }
    }

    public class a implements Parcelable.Creator<ImageModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ImageModel createFromParcel(Parcel r100) {
            return new ImageModel(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ImageModel[] newArray(int r100) {
            return new ImageModel[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return hash(new Object[]{this.avgColor, this.mUri, this.mUrls, Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }

    static {
        CREATOR = new a();
    }

    public ImageModel() {
        super(py.k.class);
        this.mUrls = new ArrayList();
        this.isNinePatch = false;
        this.isResizableImg = false;
    }

    @Override // py.k
    @SerializedName("image_type")
    public Integer getImageType() {
        return Integer.valueOf(this.imageType);
    }

    @Override // py.k
    public boolean isValid() {
        List<String> r100 = this.mUrls;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.size() <= 0) goto L7;
        return true;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("{\"uri\":\"");
        String r101 = this.mUri;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append("\",\"image_type\":\"");
        String r103 = this.schema;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        r100.append(r102);
        r100.append("\",\"url_list\":[");
        List<String> r104 = this.mUrls;
        if (r104 == null) goto L17;
        int r105 = r104.size();
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L17;
        r100.append("\"");
        r100.append((String) ListProtector.get(this.mUrls, r106));
        r100.append("\"");
        if (r106 == (r105 - 1)) goto L16;
        r100.append(",");
    L16:
        r106 = r106 + 1;
    L17:
        r100.append("]}");
        return r100.toString();
    }

    public ImageModel copy() {
        return fromJson(toJsonString(this));
    }

    @Override // py.k
    @SerializedName("content")
    public /* bridge */ /* synthetic */ py.k.b getImageContent() {
        return getImageContent();
    }

    @Override // py.k
    public String getAvgColor() {
        return this.avgColor;
    }

    @Override // py.k
    public int getHeight() {
        return this.height;
    }

    @Override // py.k
    public String getIconStub() {
        return this.iconStub;
    }

    @Override // py.k
    @SerializedName("open_web_url")
    public String getSchema() {
        return this.schema;
    }

    @Override // py.k
    @SerializedName("uri")
    public String getUri() {
        return this.mUri;
    }

    @Override // py.k, py.l
    @SerializedName(ScoreTags.STAR_URL_LIST)
    public List<String> getUrls() {
        return this.mUrls;
    }

    @Override // py.k
    public List<String> getUrlsKmp() {
        return this.mUrls;
    }

    @Override // py.k
    public int getWidth() {
        return this.width;
    }

    @Override // py.k
    @SerializedName("is_animated")
    public boolean isAnimated() {
        return this.isAnimated;
    }

    @Override // py.k
    public boolean isFeedCandidate() {
        return this.isFeedCandidate;
    }

    @Override // py.k
    public boolean isLoaded() {
        return this.isLoaded;
    }

    @Override // py.k
    public boolean isMonitored() {
        return this.isMonitored;
    }

    @Override // py.k
    public boolean isResizableImg() {
        return this.isResizableImg;
    }

    @Override // py.k
    @SerializedName("content")
    public Content getImageContent() {
        return this.content;
    }

    public ImageModel(Parcel r100) {
        super(py.k.class);
        this.mUrls = new ArrayList();
        boolean r101 = false;
        this.isNinePatch = false;
        this.isResizableImg = false;
        this.mUri = r100.readString();
        this.mUrls = r100.createStringArrayList();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.schema = r100.readString();
        this.imageType = r100.readInt();
        this.content = (Content) r100.readParcelable(Content.class.getClassLoader());
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isAnimated = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.isLoaded = r103;
        if (r100.readByte() == 0) goto L13;
        boolean r104 = true;
    L14:
        this.isMonitored = r104;
        if (r100.readByte() == 0) goto L17;
        r101 = true;
    L17:
        this.isFeedCandidate = r101;
        return;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = false;
        goto L6
    }

    public static ImageModel fromJson(JSONObject r100) {
        return (ImageModel) GsonProtectorUtils.fromJson(GsonHelper.get(), r100.toString(), ImageModel.class);
    }

    public static ImageModel genBy(String r100) {
        ImageModel r101 = new ImageModel();
        r101.setUrls(Collections.singletonList(r100));
        return r101;
    }

    private static int hash(Object... r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = 1;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L12;
        Object r104 = r100[r103];
        int r105 = r102 * 31;
        if (r104 != null) goto L10;
        int r106 = 0;
    L11:
        r102 = r105 + r106;
        r103 = r103 + 1;
        goto L6
    L10:
        r106 = r104.hashCode();
        goto L11
    L12:
        return r102;
    }

    public static String toJsonString(ImageModel r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return GsonProtectorUtils.toJson(GsonHelper.get(), r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L23;
        ImageModel r101 = (ImageModel) r100;
        if (this.width == r101.width) goto L13;
    L21:
        return false;
    L13:
        if (this.height != r101.height) goto L21;
        if (equals(this.avgColor, r101.avgColor) == false) goto L21;
        if (equals(this.mUri, r101.mUri) == false) goto L21;
        if (equals(this.mUrls, r101.mUrls) == false) goto L21;
        return true;
    }

    @Override // py.k
    public boolean equalsOnlyUri(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return equals(this.mUri, ((ImageModel) r100).mUri);
    }

    @Override // py.k
    @SerializedName("is_animated")
    public void setAnimated(boolean r100) {
        this.isAnimated = r100;
    }

    @Override // py.k
    public void setAvgColor(String r100) {
        this.avgColor = r100;
    }

    @Override // py.k
    @SerializedName("content")
    public void setContent(py.k.b r100) {
        this.content = (Content) m.b(r100, Content.class);
    }

    public void setFeedCandidate(boolean r100) {
        this.isFeedCandidate = r100;
    }

    @Override // py.k
    public void setHeight(int r100) {
        this.height = r100;
    }

    @Override // py.k
    public void setIconStub(String r100) {
        this.iconStub = r100;
    }

    @Override // py.k
    @SerializedName("image_type")
    public void setImageType(Integer r100) {
        this.imageType = r100.intValue();
    }

    @Override // py.k
    public void setIsResizableImg(boolean r100) {
        this.isResizableImg = r100;
    }

    @Override // py.k
    public void setLoaded(boolean r100) {
        this.isLoaded = r100;
    }

    public void setMonitored(boolean r100) {
        this.isMonitored = r100;
    }

    @Override // py.k
    @SerializedName("open_web_url")
    public void setSchema(String r100) {
        this.schema = r100;
    }

    @Override // py.k
    @SerializedName("uri")
    public void setUri(String r100) {
        this.mUri = r100;
    }

    @Override // py.k
    @SerializedName(ScoreTags.STAR_URL_LIST)
    public void setUrls(List<String> r100) {
        this.mUrls = r100;
    }

    @Override // py.k
    public void setWidth(int r100) {
        this.width = r100;
    }

    public static ImageModel fromJson(String r100) {
        return (ImageModel) GsonProtectorUtils.fromJson(GsonHelper.get(), r100, ImageModel.class);
    }

    public ImageModel(String r100, List<String> r101) {
        super(py.k.class);
        new ArrayList();
        this.isNinePatch = false;
        this.isResizableImg = false;
        this.mUri = r100;
        this.mUrls = r101;
    }

    private static boolean equals(Object r100, Object r101) {
        if (r100 == r101) goto L8;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.equals(r101) == false) goto L7;
    L8:
        return true;
    }

    public static ImageModel genBy(String r100, List<String> r101) {
        ImageModel r102 = new ImageModel();
        r102.setUri(r100);
        r102.setUrls(r101);
        return r102;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mUri);
        r100.writeStringList(this.mUrls);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeString(this.schema);
        r100.writeInt(this.imageType);
        r100.writeParcelable(this.content, r101);
        r100.writeByte(this.isAnimated ? 1 : 0);
        r100.writeByte(this.isLoaded ? 1 : 0);
        r100.writeByte(this.isMonitored ? 1 : 0);
        r100.writeByte(this.isFeedCandidate ? 1 : 0);
    }

    public ImageModel(String r100, List<String> r101, String r102) {
        super(py.k.class);
        new ArrayList();
        this.isNinePatch = false;
        this.isResizableImg = false;
        this.mUri = r100;
        this.mUrls = r101;
        this.schema = r102;
    }
}
