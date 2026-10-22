package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Callback;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/stepos/deepbinder/core/entity/parser/Parser;", "", AppAgent.CONSTRUCT, "()V", "Landroid/os/Parcel;", "parcel", "Lcom/stepos/deepbinder/core/entity/Call;", "parserCall", "(Landroid/os/Parcel;)Lcom/stepos/deepbinder/core/entity/Call;", "Lcom/stepos/deepbinder/core/entity/Callback;", "parserCallback", "(Landroid/os/Parcel;)Lcom/stepos/deepbinder/core/entity/Callback;", "Lcom/stepos/deepbinder/core/entity/Reply;", "parserReply", "(Landroid/os/Parcel;)Lcom/stepos/deepbinder/core/entity/Reply;", "call", "", "flags", "LC7/r;", "writeCall", "(Lcom/stepos/deepbinder/core/entity/Call;Landroid/os/Parcel;I)V", "callback", "writeCallback", "(Lcom/stepos/deepbinder/core/entity/Callback;Landroid/os/Parcel;I)V", Constants.PARAM_REPLY, "writeReply", "(Lcom/stepos/deepbinder/core/entity/Reply;Landroid/os/Parcel;I)V", "", "TAG", "Ljava/lang/String;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Parser {
    public static final Parser INSTANCE = new Parser();
    private static final String TAG = "Parser";

    private Parser() {
    }

    public final Call parserCall(Parcel parcel) {
        k.f(parcel, "parcel");
        int i = parcel.readInt();
        return (i < 0 || i >= 3) ? Call.INSTANCE.create().withProtocolInvalidFlag(true) : CallParser.INSTANCE.parserCallFromParcel(parcel, i);
    }

    public final Callback parserCallback(Parcel parcel) throws Exception {
        k.f(parcel, "parcel");
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
        k.f(parcel, "parcel");
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

    public final void writeCall(Call call, Parcel parcel, int flags) {
        k.f(call, "call");
        k.f(parcel, "parcel");
        parcel.writeInt(call.getProtocolVersion());
        CallParser.INSTANCE.writeCallIntoParcel(call, parcel, call.getProtocolVersion(), flags);
    }

    public final void writeCallback(Callback callback, Parcel parcel, int flags) {
        k.f(callback, "callback");
        k.f(parcel, "parcel");
        parcel.writeInt(callback.getProtocolVersion());
        CallbackParser.INSTANCE.writeCallbackIntoParcel(callback, parcel, callback.getProtocolVersion(), flags);
    }

    public final void writeReply(Reply reply, Parcel parcel, int flags) {
        k.f(reply, "reply");
        k.f(parcel, "parcel");
        parcel.writeInt(reply.getProtocolVersion());
        ReplyParser.INSTANCE.writeReplyIntoParcel(reply, parcel, reply.getProtocolVersion(), flags);
    }
}
