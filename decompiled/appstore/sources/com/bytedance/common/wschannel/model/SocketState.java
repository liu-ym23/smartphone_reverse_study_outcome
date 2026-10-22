package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ChannelType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SocketState implements Parcelable {
    public static final Parcelable.Creator<SocketState> CREATOR = null;
    public int channelId;
    public int channelType;
    public int connectionState;
    public int connectionType;
    public String connectionUrl;
    public String error;
    public int errorCode;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public SocketState a(Parcel r10) {
            return new SocketState(r10);
        }

        public SocketState[] b(int r10) {
            return new SocketState[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public SocketState() {
    }

    public static SocketState fromJson(JSONObject r10) {
        SocketState r11 = new SocketState();
        r11.channelId = r10.optInt(WsConstants.KEY_CHANNEL_ID, Integer.MIN_VALUE);
        r11.connectionType = r10.optInt("type", -1);
        r11.connectionState = r10.optInt(WsConstants.KEY_CONNECTION_STATE, -1);
        r11.connectionUrl = r10.optString("url", "");
        r11.channelType = r10.optInt(WsConstants.KEY_CHANNEL_TYPE);
        r11.error = r10.optString("error", "");
        r11.errorCode = r10.optInt(WsConstants.ERROR_CODE);
        return r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public ChannelType getChannelType() {
        return ChannelType.of(this.channelType);
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public String getConnectionUrl() {
        return this.connectionUrl;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setChannelId(int r10) {
        this.channelId = r10;
    }

    public void setConnectionState(int r10) {
        this.connectionState = r10;
    }

    public void setConnectionType(int r10) {
        this.connectionType = r10;
    }

    public void setConnectionUrl(String r10) {
        this.connectionUrl = r10;
    }

    public void setErrorCode(int r10) {
        this.errorCode = r10;
    }

    public JSONObject toJson() {
        JSONObject r10 = new JSONObject();
        r10.put(WsConstants.KEY_CHANNEL_ID, this.channelId);     // Catch: JSONException -> L5
        r10.put("type", this.connectionType);     // Catch: JSONException -> L5
        r10.put(WsConstants.KEY_CONNECTION_STATE, this.connectionState);     // Catch: JSONException -> L5
        r10.put("url", this.connectionUrl);     // Catch: JSONException -> L5
        r10.put(WsConstants.KEY_CHANNEL_TYPE, this.channelType);     // Catch: JSONException -> L5
        r10.put("error", this.error);     // Catch: JSONException -> L5
        r10.put(WsConstants.ERROR_CODE, this.errorCode);     // Catch: JSONException -> L5
    L7:
        return r10;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public String toString() {
        return "SocketState{connectionType=" + this.connectionType + ", connectionState=" + this.connectionState + ", connectionUrl='" + this.connectionUrl + "', channelId=" + this.channelId + ", channelType=" + this.channelType + ", error='" + this.error + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.connectionType);
        r10.writeInt(this.connectionState);
        r10.writeString(this.connectionUrl);
        r10.writeInt(this.channelId);
        r10.writeInt(this.channelType);
        r10.writeString(this.error);
        r10.writeInt(this.errorCode);
    }

    public SocketState(Parcel r10) {
        this.connectionType = r10.readInt();
        this.connectionState = r10.readInt();
        this.connectionUrl = r10.readString();
        this.channelId = r10.readInt();
        this.channelType = r10.readInt();
        this.error = r10.readString();
        this.errorCode = r10.readInt();
    }
}
