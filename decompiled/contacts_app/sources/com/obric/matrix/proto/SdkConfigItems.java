package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class SdkConfigItems extends Message<SdkConfigItems, Builder> {
    public static final ProtoAdapter<SdkConfigItems> ADAPTER = null;
    public static final Boolean DEFAULT_ISALLUSEBIND = null;
    public static final Integer DEFAULT_POLLINGINTERVAL = null;
    public static final Integer DEFAULT_SENDCMDTIMEOUT = null;
    private static final long serialVersionUID = 0;

    @SerializedName("extraConfigs")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final Map<String, String> extraConfigs;

    @SerializedName("forceUseOldBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 6)
    public final List<Integer> forceUseOldBindCmd;

    @SerializedName("isAllUseBind")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean isAllUseBind;

    @SerializedName("pollingInterval")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer pollingInterval;

    @SerializedName("sendCmdTimeout")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer sendCmdTimeout;

    @SerializedName("useBindCmd")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 2)
    public final List<Integer> useBindCmd;

    public static final class Builder extends Message.Builder<SdkConfigItems, Builder> {
        public Map<String, String> extraConfigs;
        public List<Integer> forceUseOldBindCmd;
        public Boolean isAllUseBind;
        public Integer pollingInterval;
        public Integer sendCmdTimeout;
        public List<Integer> useBindCmd;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            this.isAllUseBind = false;
            this.sendCmdTimeout = 0;
            this.pollingInterval = 0;
            this.useBindCmd = Internal.newMutableList();
            this.extraConfigs = Internal.newMutableMap();
            this.forceUseOldBindCmd = Internal.newMutableList();
        }

        public Builder isAllUseBind(Boolean r1) {
            this.isAllUseBind = r1;
            return this;
        }

        public Builder useBindCmd(List<Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.useBindCmd = r1;
            return this;
        }

        public Builder sendCmdTimeout(Integer r1) {
            this.sendCmdTimeout = r1;
            return this;
        }

        public Builder pollingInterval(Integer r1) {
            this.pollingInterval = r1;
            return this;
        }

        public Builder extraConfigs(Map<String, String> r1) {
            Internal.checkElementsNotNull(r1);
            this.extraConfigs = r1;
            return this;
        }

        public Builder forceUseOldBindCmd(List<Integer> r1) {
            Internal.checkElementsNotNull(r1);
            this.forceUseOldBindCmd = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public SdkConfigItems build() {
            return new SdkConfigItems(this.isAllUseBind, this.useBindCmd, this.sendCmdTimeout, this.pollingInterval, this.extraConfigs, this.forceUseOldBindCmd, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_SdkConfigItems extends ProtoAdapter<SdkConfigItems> {
        private final ProtoAdapter<Map<String, String>> extraConfigs;

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkConfigItems decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, SdkConfigItems r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkConfigItems r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkConfigItems redact(SdkConfigItems r1) {
            return redact2(r1);
        }

        public ProtoAdapter_SdkConfigItems() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkConfigItems.class);
            this.extraConfigs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.STRING);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SdkConfigItems r5) {
            return (((((ProtoAdapter.BOOL.encodedSizeWithTag(1, r5.isAllUseBind) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(2, r5.useBindCmd)) + ProtoAdapter.INT32.encodedSizeWithTag(3, r5.sendCmdTimeout)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r5.pollingInterval)) + this.extraConfigs.encodedSizeWithTag(5, r5.extraConfigs)) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(6, r5.forceUseOldBindCmd)) + r5.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r4, SdkConfigItems r5) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r4, 1, r5.isAllUseBind);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 2, r5.useBindCmd);
            ProtoAdapter.INT32.encodeWithTag(r4, 3, r5.sendCmdTimeout);
            ProtoAdapter.INT32.encodeWithTag(r4, 4, r5.pollingInterval);
            this.extraConfigs.encodeWithTag(r4, 5, r5.extraConfigs);
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r4, 6, r5.forceUseOldBindCmd);
            r4.writeBytes(r5.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SdkConfigItems decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.forceUseOldBindCmd.add(ProtoAdapter.INT32.decode(r7));
            goto L3
        L8:
            r0.extraConfigs.putAll(this.extraConfigs.decode(r7));
            goto L3
        L9:
            r0.pollingInterval(ProtoAdapter.INT32.decode(r7));
            goto L3
        L10:
            r0.sendCmdTimeout(ProtoAdapter.INT32.decode(r7));
            goto L3
        L11:
            r0.useBindCmd.add(ProtoAdapter.INT32.decode(r7));
            goto L3
        L12:
            r0.isAllUseBind(ProtoAdapter.BOOL.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public SdkConfigItems redact2(SdkConfigItems r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_SdkConfigItems();
        DEFAULT_ISALLUSEBIND = false;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public SdkConfigItems(Boolean r9, List<Integer> r10, Integer r11, Integer r12, Map<String, String> r13, List<Integer> r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public SdkConfigItems(Boolean r2, List<Integer> r3, Integer r4, Integer r5, Map<String, String> r6, List<Integer> r7, ByteString r8) {
        super(ADAPTER, r8);
        this.isAllUseBind = r2;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r3);
        this.sendCmdTimeout = r4;
        this.pollingInterval = r5;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r6);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r7);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.isAllUseBind = this.isAllUseBind;
        r0.useBindCmd = Internal.copyOf("useBindCmd", this.useBindCmd);
        r0.sendCmdTimeout = this.sendCmdTimeout;
        r0.pollingInterval = this.pollingInterval;
        r0.extraConfigs = Internal.copyOf("extraConfigs", this.extraConfigs);
        r0.forceUseOldBindCmd = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof SdkConfigItems) == true) goto L8;
        return false;
    L8:
        SdkConfigItems r6 = (SdkConfigItems) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L24;
        if (Internal.equals(this.isAllUseBind, r6.isAllUseBind) == false) goto L24;
        if (this.useBindCmd.equals(r6.useBindCmd) == false) goto L24;
        if (Internal.equals(this.sendCmdTimeout, r6.sendCmdTimeout) == false) goto L24;
        if (Internal.equals(this.pollingInterval, r6.pollingInterval) == false) goto L24;
        if (this.extraConfigs.equals(r6.extraConfigs) == false) goto L24;
        if (this.forceUseOldBindCmd.equals(r6.forceUseOldBindCmd) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L17;
        int r1 = unknownFields().hashCode() * 37;
        Boolean r2 = this.isAllUseBind;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (((r1 + r4) * 37) + this.useBindCmd.hashCode()) * 37;
        Integer r6 = this.sendCmdTimeout;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        Integer r9 = this.pollingInterval;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        int r10 = ((((r8 + r3) * 37) + this.extraConfigs.hashCode()) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r10;
        return r10;
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L17:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.isAllUseBind == null) goto L5;
        r0.append(", isAllUseBind=").append(this.isAllUseBind);
    L5:
        List<Integer> r1 = this.useBindCmd;
        if (r1 == null) goto L11;
        if (r1.isEmpty() == true) goto L11;
        r0.append(", useBindCmd=").append(this.useBindCmd);
    L11:
        if (this.sendCmdTimeout == null) goto L14;
        r0.append(", sendCmdTimeout=").append(this.sendCmdTimeout);
    L14:
        if (this.pollingInterval == null) goto L16;
        r0.append(", pollingInterval=").append(this.pollingInterval);
    L16:
        Map<String, String> r2 = this.extraConfigs;
        if (r2 != null) goto L19;
    L21:
        List<Integer> r3 = this.forceUseOldBindCmd;
        if (r3 == null) goto L27;
        if (r3.isEmpty() == true) goto L27;
        r0.append(", forceUseOldBindCmd=").append(this.forceUseOldBindCmd);
    L27:
        return r0.replace(0, 2, "SdkConfigItems{").append('}').toString();
    L19:
        if (r2.isEmpty() == true) goto L21;
        r0.append(", extraConfigs=").append(this.extraConfigs);
        goto L21
    }
}
