package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import v7.d;
import v7.h;
import v7.j;
import v7.o;

/* loaded from: classes2.dex */
public final class Event$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Event$Builder(int i) {
        this();
    }

    public Event$Builder clearData() {
        copyOnWrite();
        d.D((d) this.instance);
        return this;
    }

    public Event$Builder clearEventId() {
        copyOnWrite();
        d.E((d) this.instance);
        return this;
    }

    public Event$Builder clearItem() {
        copyOnWrite();
        d.F((d) this.instance);
        return this;
    }

    public Event$Builder clearMessageDelta() {
        copyOnWrite();
        d.G((d) this.instance);
        return this;
    }

    public Event$Builder clearTask() {
        copyOnWrite();
        d.H((d) this.instance);
        return this;
    }

    public Event$Builder clearTaskId() {
        copyOnWrite();
        d.I((d) this.instance);
        return this;
    }

    public Event$Builder clearType() {
        copyOnWrite();
        d.J((d) this.instance);
        return this;
    }

    public Event$DataCase getDataCase() {
        return ((d) this.instance).X();
    }

    public String getEventId() {
        return ((d) this.instance).Y();
    }

    public ByteString getEventIdBytes() {
        return ((d) this.instance).Z();
    }

    public h getItem() {
        return ((d) this.instance).a0();
    }

    public j getMessageDelta() {
        return ((d) this.instance).b0();
    }

    public o getTask() {
        return ((d) this.instance).c0();
    }

    public String getTaskId() {
        return ((d) this.instance).d0();
    }

    public ByteString getTaskIdBytes() {
        return ((d) this.instance).e0();
    }

    public String getType() {
        return ((d) this.instance).f0();
    }

    public ByteString getTypeBytes() {
        return ((d) this.instance).g0();
    }

    public boolean hasItem() {
        return ((d) this.instance).h0();
    }

    public boolean hasMessageDelta() {
        return ((d) this.instance).i0();
    }

    public boolean hasTask() {
        return ((d) this.instance).j0();
    }

    public Event$Builder mergeItem(h hVar) {
        copyOnWrite();
        d.K((d) this.instance, hVar);
        return this;
    }

    public Event$Builder mergeMessageDelta(j jVar) {
        copyOnWrite();
        d.L((d) this.instance, jVar);
        return this;
    }

    public Event$Builder mergeTask(o oVar) {
        copyOnWrite();
        d.M((d) this.instance, oVar);
        return this;
    }

    public Event$Builder setEventId(String str) {
        copyOnWrite();
        d.N((d) this.instance, str);
        return this;
    }

    public Event$Builder setEventIdBytes(ByteString byteString) {
        copyOnWrite();
        d.O((d) this.instance, byteString);
        return this;
    }

    public Event$Builder setItem(h hVar) {
        copyOnWrite();
        d.P((d) this.instance, hVar);
        return this;
    }

    public Event$Builder setMessageDelta(j jVar) {
        copyOnWrite();
        d.Q((d) this.instance, jVar);
        return this;
    }

    public Event$Builder setTask(o oVar) {
        copyOnWrite();
        d.R((d) this.instance, oVar);
        return this;
    }

    public Event$Builder setTaskId(String str) {
        copyOnWrite();
        d.S((d) this.instance, str);
        return this;
    }

    public Event$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        d.T((d) this.instance, byteString);
        return this;
    }

    public Event$Builder setType(String str) {
        copyOnWrite();
        d.U((d) this.instance, str);
        return this;
    }

    public Event$Builder setTypeBytes(ByteString byteString) {
        copyOnWrite();
        d.V((d) this.instance, byteString);
        return this;
    }

    private Event$Builder() {
        super(d.DEFAULT_INSTANCE);
    }

    public Event$Builder setItem(Item$Builder item$Builder) {
        copyOnWrite();
        d.P((d) this.instance, (h) item$Builder.k());
        return this;
    }

    public Event$Builder setMessageDelta(MessageDelta$Builder messageDelta$Builder) {
        copyOnWrite();
        d.Q((d) this.instance, (j) messageDelta$Builder.k());
        return this;
    }

    public Event$Builder setTask(Task$Builder task$Builder) {
        copyOnWrite();
        d.R((d) this.instance, (o) task$Builder.k());
        return this;
    }
}
