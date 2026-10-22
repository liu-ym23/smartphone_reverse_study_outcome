package com.bytedance.android.livesdk.feed.tab.model;

import am3.g;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes8.dex */
@ProtoMessage("webcast.api.tab.TabItem")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b-\u0010.R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/android/livesdk/feed/tab/model/a;", "", "", DBDefinition.ID, "I", "get_id", "()I", "set_id", "(I)V", "_type", "get_type", "set_type", "", "_name", "Ljava/lang/String;", "get_name", "()Ljava/lang/String;", "set_name", "(Ljava/lang/String;)V", "_style", "get_style", "set_style", "_dislike", "get_dislike", "set_dislike", "_event", "get_event", "set_event", "", "_enableSource", "Ljava/util/List;", "get_enableSource", "()Ljava/util/List;", "set_enableSource", "(Ljava/util/List;)V", "_disableEnableSource", "get_disableEnableSource", "set_disableEnableSource", "", "_customLayout", "Z", "get_customLayout", "()Z", "set_customLayout", "(Z)V", "<init>", "()V", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("custom_layout")
    protected boolean _customLayout;

    @SerializedName("shield_enter_source")
    protected List<String> _disableEnableSource;

    @SerializedName("enable_dislike")
    protected int _dislike;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ENTER_SOURCE)
    protected List<String> _enableSource;

    @SerializedName("event")
    protected String _event;

    @SerializedName("id")
    protected int _id;

    @SerializedName("name")
    protected String _name;

    @SerializedName("style")
    protected int _style;

    @SerializedName("type")
    protected int _type;

    public a() {
    }

    public final e a() {
        e r100 = new e();
        r100.x(this._id);
        r100.z(this._name);
        r100.D(this._style);
        r100.u(this._dislike);
        r100.A(this._event);
        r100.v(this._enableSource);
        r100.t(this._disableEnableSource);
        r100.E(this._type);
        r100.s(this._customLayout);
        return r100;
    }

    public a(g r100) {
        this._enableSource = new ArrayList();
        this._disableEnableSource = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this._customLayout = am3.h.a(r100);
        goto L3
    L8:
        List<String> r103 = this._disableEnableSource;
    L10:
        r103.add(am3.h.c(r100));
        goto L3
    L9:
        r103 = this._enableSource;
        goto L10
    L11:
        this._type = (int) r100.j();
        goto L3
    L12:
        this._event = am3.h.c(r100);
        goto L3
    L13:
        this._dislike = (int) r100.j();
        goto L3
    L14:
        this._style = (int) r100.j();
        goto L3
    L15:
        this._name = am3.h.c(r100);
        goto L3
    L16:
        this._id = (int) r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
    }
}
