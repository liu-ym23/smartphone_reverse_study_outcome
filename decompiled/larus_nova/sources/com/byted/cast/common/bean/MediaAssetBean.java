package com.byted.cast.common.bean;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class MediaAssetBean {
    private String agentType;
    private String album;
    private String albumArtUrl;
    private String artist;
    private int audioTrack;
    private List<String> audioTrackList;
    private String cencKey;
    private String codec;
    private int commentCount;
    private String creator;
    private String customDlnaXmlElement;
    private String danmakuUrl;
    private String desc;
    private int diggCount;
    private long duration;
    private String extra;
    private String genre;
    private boolean isLike;
    private String lyrics;
    private int mediaType;
    private String mimeType;
    private int oversea;
    private String publisher;
    private String sceneId;
    private SkipInfo skipInfo;
    private long startPosition;
    private String storageMedium;
    private Subtitle subtitle;
    private String title;
    private String vid;
    private String writeStatus;

    public MediaAssetBean() {
    }

    public JSONObject encode() {
        JSONObject r100 = new JSONObject();
        r100.put("dc:title", this.title);     // Catch: JSONException -> L5
        r100.put("dc:creator", this.creator);     // Catch: JSONException -> L5
        r100.put("dc:publisher", this.publisher);     // Catch: JSONException -> L5
        r100.put("upnp:artist", this.artist);     // Catch: JSONException -> L5
        r100.put("upnp:album", this.album);     // Catch: JSONException -> L5
        r100.put("upnp:albumArtURI", this.albumArtUrl);     // Catch: JSONException -> L5
        r100.put("upnp:storageMedium", this.storageMedium);     // Catch: JSONException -> L5
        r100.put("upnp:writeStatus", this.writeStatus);     // Catch: JSONException -> L5
        r100.put("upnp:genre", this.genre);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "MediaAssetBean{vid='" + this.vid + "', title='" + this.title + "', desc='" + this.desc + "', creator='" + this.creator + "', artist='" + this.artist + "', album='" + this.album + "', albumArtURI='" + this.albumArtUrl + "', danmakuUrl='" + this.danmakuUrl + "', lyrics='" + this.lyrics + "', duration=" + this.duration + ", isLike=" + this.isLike + ", diggCount=" + this.diggCount + ", commentCount=" + this.commentCount + ", mimeType='" + this.mimeType + "', mediaType=" + this.mediaType + ", startPosition=" + this.startPosition + ", publisher='" + this.publisher + "', customDlnaXmlElement='" + this.customDlnaXmlElement + "', extra='" + this.extra + "'}";
    }

    public String getAgentType() {
        return this.agentType;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getAlbumArtUrl() {
        return this.albumArtUrl;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getAudioTrack() {
        return this.audioTrack;
    }

    public List<String> getAudioTrackList() {
        return this.audioTrackList;
    }

    public String getCencKey() {
        return this.cencKey;
    }

    public String getCodec() {
        return this.codec;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getCreator() {
        return this.creator;
    }

    public String getCustomDlnaXmlElement() {
        return this.customDlnaXmlElement;
    }

    public String getDanmakuUrl() {
        return this.danmakuUrl;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getDiggCount() {
        return this.diggCount;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getLyrics() {
        return this.lyrics;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getOversea() {
        return this.oversea;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public SkipInfo getSkipInfo() {
        return this.skipInfo;
    }

    public long getStartPosition() {
        return this.startPosition;
    }

    public Subtitle getSubtitle() {
        return this.subtitle;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVid() {
        return this.vid;
    }

    public boolean isLike() {
        return this.isLike;
    }

    public void setAgentType(String r100) {
        this.agentType = r100;
    }

    public void setAlbum(String r100) {
        this.album = r100;
    }

    public void setAlbumArtUrl(String r100) {
        this.albumArtUrl = r100;
    }

    public void setArtist(String r100) {
        this.artist = r100;
    }

    public void setAudioTrack(int r100) {
        this.audioTrack = r100;
    }

    public void setAudioTrackList(List<String> r100) {
        this.audioTrackList = r100;
    }

    public void setCencKey(String r100) {
        this.cencKey = r100;
    }

    public void setCodec(String r100) {
        this.codec = r100;
    }

    public void setCommentCount(int r100) {
        this.commentCount = r100;
    }

    public void setCreator(String r100) {
        this.creator = r100;
    }

    public void setCustomDlnaXmlElement(String r100) {
        this.customDlnaXmlElement = r100;
    }

    public void setDanmakuUrl(String r100) {
        this.danmakuUrl = r100;
    }

    public void setDesc(String r100) {
        this.desc = r100;
    }

    public void setDiggCount(int r100) {
        this.diggCount = r100;
    }

    public void setDuration(long r100) {
        this.duration = r100;
    }

    public void setExtra(String r100) {
        this.extra = r100;
    }

    public void setLike(boolean r100) {
        this.isLike = r100;
    }

    public void setLyrics(String r100) {
        this.lyrics = r100;
    }

    public void setMediaType(int r100) {
        this.mediaType = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setOversea(int r100) {
        this.oversea = r100;
    }

    public void setPublisher(String r100) {
        this.publisher = r100;
    }

    public void setSceneId(String r100) {
        this.sceneId = r100;
    }

    public void setSkipInfo(SkipInfo r100) {
        this.skipInfo = r100;
    }

    public void setStartPosition(long r100) {
        this.startPosition = r100;
    }

    public void setSubtitle(Subtitle r100) {
        this.subtitle = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setVid(String r100) {
        this.vid = r100;
    }
}
