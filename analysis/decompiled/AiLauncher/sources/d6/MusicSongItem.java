package d6;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001b\u0010\u000eR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b\u001f\u0010\u001e¨\u0006 "}, d2 = {"Ld6/q;", "", "", "title", "coverUrl", "linkUrl", "id", "contentId", "", "artists", "badges", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "getLinkUrl", "c", "getContentId", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "getBadges", "migu_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: d6.q, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class MusicSongItem {

    @SerializedName("artists")
    private final List<String> artists;

    @SerializedName("badges")
    private final List<String> badges;

    @SerializedName("contentId")
    private final String contentId;

    @SerializedName("coverUrl")
    private final String coverUrl;

    @SerializedName("songId")
    private final String id;

    @SerializedName("linkUrl")
    private final String linkUrl;

    @SerializedName("title")
    private final String title;

    public MusicSongItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public final List<String> a() {
        return this.artists;
    }

    /* renamed from: b, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MusicSongItem)) {
            return false;
        }
        MusicSongItem musicSongItem = (MusicSongItem) other;
        return kotlin.jvm.internal.p.d(this.title, musicSongItem.title) && kotlin.jvm.internal.p.d(this.coverUrl, musicSongItem.coverUrl) && kotlin.jvm.internal.p.d(this.linkUrl, musicSongItem.linkUrl) && kotlin.jvm.internal.p.d(this.id, musicSongItem.id) && kotlin.jvm.internal.p.d(this.contentId, musicSongItem.contentId) && kotlin.jvm.internal.p.d(this.artists, musicSongItem.artists) && kotlin.jvm.internal.p.d(this.badges, musicSongItem.badges);
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.coverUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.linkUrl;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.id;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.contentId;
        return ((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.artists.hashCode()) * 31) + this.badges.hashCode();
    }

    public String toString() {
        return "MusicSongItem(title=" + this.title + ", coverUrl=" + this.coverUrl + ", linkUrl=" + this.linkUrl + ", id=" + this.id + ", contentId=" + this.contentId + ", artists=" + this.artists + ", badges=" + this.badges + ")";
    }

    public MusicSongItem(String str, String str2, String str3, String str4, String str5, List<String> artists, List<String> badges) {
        kotlin.jvm.internal.p.i(artists, "artists");
        kotlin.jvm.internal.p.i(badges, "badges");
        this.title = str;
        this.coverUrl = str2;
        this.linkUrl = str3;
        this.id = str4;
        this.contentId = str5;
        this.artists = artists;
        this.badges = badges;
    }

    public /* synthetic */ MusicSongItem(String str, String str2, String str3, String str4, String str5, List list, List list2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4, (i10 & 16) != 0 ? null : str5, (i10 & 32) != 0 ? C1173v.m() : list, (i10 & 64) != 0 ? C1173v.m() : list2);
    }
}
