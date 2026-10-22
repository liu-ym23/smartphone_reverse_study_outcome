package com.stepos.deepbinder.core.entity.parser;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.ParameterWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import kotlin.jvm.internal.g;
import x9.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ReplyParser {
    public static final ReplyParser INSTANCE = new ReplyParser();

    private ReplyParser() {
    }

    public static /* synthetic */ Reply parserReplyFromParcel$default(ReplyParser replyParser, Parcel parcel, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return replyParser.parserReplyFromParcel(parcel, i10);
    }

    public static /* synthetic */ void writeReplyIntoParcel$default(ReplyParser replyParser, Reply reply, Parcel parcel, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        replyParser.writeReplyIntoParcel(reply, parcel, i10, i11);
    }

    public final Reply parserReplyFromParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        Reply replyObtain = Reply.CREATOR.obtain();
        replyObtain.setProtocolVersion(i10);
        ParameterWrapper[] parameterWrapperArr = null;
        if (parcel.readByte() == 0) {
            Parcelable parcelable = parcel.readParcelable(IPCException.class.getClassLoader());
            replyObtain.setIpcException(parcelable instanceof IPCException ? (IPCException) parcelable : null);
        }
        if (parcel.readByte() == 0) {
            int i11 = parcel.readInt();
            if (i11 >= 0) {
                parameterWrapperArr = new ParameterWrapper[i11];
                for (int i12 = 0; i12 < i11; i12++) {
                    parameterWrapperArr[i12] = ParameterWrapperParser.INSTANCE.parserParameterWrapperFromParcel(parcel, i10);
                }
            }
            replyObtain.setFlowParameterWrappers(parameterWrapperArr);
        }
        replyObtain.setInvokeTime(parcel.readInt());
        replyObtain.setResult(f.d(ReplyParser.class.getClassLoader(), parcel, i10));
        replyObtain.setExtraInfoMap(parcel.readHashMap(ReplyParser.class.getClassLoader()));
        return replyObtain;
    }

    public final void writeReplyIntoParcel(Reply reply, Parcel parcel, int i10, int i11) {
        g.f(reply, "reply");
        g.f(parcel, "parcel");
        if (reply.getIpcException() != null) {
            parcel.writeByte((byte) 0);
            parcel.writeParcelable(reply.getIpcException(), i11);
        } else {
            parcel.writeByte((byte) 1);
        }
        if (reply.getFlowParameterWrappers() != null) {
            parcel.writeByte((byte) 0);
            ParameterWrapper[] flowParameterWrappers = reply.getFlowParameterWrappers();
            if (flowParameterWrappers == null) {
                IPCLog.INSTANCE.w("SerializeUtils", "writeParameterWrapperArray parameterWrappers null", new Object[0]);
            } else {
                parcel.writeInt(flowParameterWrappers.length);
                for (ParameterWrapper parameterWrapper : flowParameterWrappers) {
                    ParameterWrapperParser.INSTANCE.writeParameterWrapperIntoParcel(parameterWrapper, parcel, i10, i11);
                }
            }
        } else {
            parcel.writeByte((byte) 1);
        }
        parcel.writeInt((int) reply.getInvokeTime());
        f.e(parcel, reply.getResult(), i10, i11);
        parcel.writeMap(reply.getExtraInfoMap());
    }
}
