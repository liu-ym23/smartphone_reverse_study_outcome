package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Parser {
    public static final Parser INSTANCE = new Parser();
    private static final String TAG = "Parser";

    private Parser() {
    }

    public final Call parserCall(Parcel parcel) {
        g.f(parcel, "parcel");
        int i10 = parcel.readInt();
        return (i10 < 0 || i10 >= 3) ? Call.CREATOR.create().withProtocolInvalidFlag(true) : CallParser.INSTANCE.parserCallFromParcel(parcel, i10);
    }

    public final Callback parserCallback(Parcel parcel) throws Exception {
        g.f(parcel, "parcel");
        int iDataPosition = parcel.dataPosition();
        try {
            Callback callback = CallbackParser.INSTANCE.parserCallbackFromParcel(parcel, parcel.readInt());
            if (parcel.dataAvail() == 0) {
                return callback;
            }
            throw new Exception("Callback parcel data is not empty");
        } catch (Exception unused) {
            IPCLog.INSTANCE.w(TAG, "[parserCallback]parse callback fail, try to degrade protocol version to match the lower side", new Object[0]);
            parcel.setDataPosition(iDataPosition);
            parcel.readInt();
            return CallbackParser.INSTANCE.parserCallbackFromParcel(parcel, 0);
        }
    }

    public final Reply parserReply(Parcel parcel) throws Exception {
        g.f(parcel, "parcel");
        int iDataPosition = parcel.dataPosition();
        try {
            Reply reply = ReplyParser.INSTANCE.parserReplyFromParcel(parcel, parcel.readInt());
            if (parcel.dataAvail() == 0) {
                return reply;
            }
            throw new Exception("Reply parcel data is not empty");
        } catch (Exception unused) {
            IPCLog.INSTANCE.w(TAG, "[parserReply]parse reply fail, try to degrade protocol version to match the lower side", new Object[0]);
            parcel.setDataPosition(iDataPosition);
            parcel.readInt();
            return ReplyParser.INSTANCE.parserReplyFromParcel(parcel, 0);
        }
    }

    public final void writeCall(Call call, Parcel parcel, int i10) {
        g.f(call, "call");
        g.f(parcel, "parcel");
        parcel.writeInt(call.getProtocolVersion());
        CallParser.INSTANCE.writeCallIntoParcel(call, parcel, call.getProtocolVersion(), i10);
    }

    public final void writeCallback(Callback callback, Parcel parcel, int i10) {
        g.f(callback, "callback");
        g.f(parcel, "parcel");
        parcel.writeInt(callback.getProtocolVersion());
        CallbackParser.INSTANCE.writeCallbackIntoParcel(callback, parcel, callback.getProtocolVersion(), i10);
    }

    public final void writeReply(Reply reply, Parcel parcel, int i10) {
        g.f(reply, "reply");
        g.f(parcel, "parcel");
        parcel.writeInt(reply.getProtocolVersion());
        ReplyParser.INSTANCE.writeReplyIntoParcel(reply, parcel, reply.getProtocolVersion(), i10);
    }
}
