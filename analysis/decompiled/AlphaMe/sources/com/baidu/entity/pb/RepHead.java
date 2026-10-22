package com.baidu.entity.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class RepHead extends f {
    public static final int MD5_FIELD_NUMBER = 1;
    public static final int MESSAGE_HEAD_FIELD_NUMBER = 3;
    public static final int RANGE_FIELD_NUMBER = 2;
    private boolean hasMd5;
    private boolean hasRange;
    private String md5_ = "";
    private String range_ = "";
    private List<MessageHead> messageHead_ = Collections.emptyList();
    private int cachedSize = -1;

    public static final class MessageHead extends f {
        public static final int LENGTH_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 3;
        public static final int OFFSET_FIELD_NUMBER = 1;
        private boolean hasLength;
        private boolean hasName;
        private boolean hasOffset;
        private int offset_ = 0;
        private int length_ = 0;
        private String name_ = "";
        private int cachedSize = -1;

        public static MessageHead parseFrom(b bVar) throws IOException {
            return new MessageHead().mergeFrom(bVar);
        }

        public final MessageHead clear() {
            clearOffset();
            clearLength();
            clearName();
            this.cachedSize = -1;
            return this;
        }

        public MessageHead clearLength() {
            this.hasLength = false;
            this.length_ = 0;
            return this;
        }

        public MessageHead clearName() {
            this.hasName = false;
            this.name_ = "";
            return this;
        }

        public MessageHead clearOffset() {
            this.hasOffset = false;
            this.offset_ = 0;
            return this;
        }

        @Override // L1.f
        public int getCachedSize() {
            if (this.cachedSize < 0) {
                getSerializedSize();
            }
            return this.cachedSize;
        }

        public int getLength() {
            return this.length_;
        }

        public String getName() {
            return this.name_;
        }

        public int getOffset() {
            return this.offset_;
        }

        @Override // L1.f
        public int getSerializedSize() {
            int iE = hasOffset() ? d.e(1, getOffset()) : 0;
            if (hasLength()) {
                iE += d.e(2, getLength());
            }
            if (hasName()) {
                iE += d.l(3, getName());
            }
            this.cachedSize = iE;
            return iE;
        }

        public boolean hasLength() {
            return this.hasLength;
        }

        public boolean hasName() {
            return this.hasName;
        }

        public boolean hasOffset() {
            return this.hasOffset;
        }

        public final boolean isInitialized() {
            return true;
        }

        public MessageHead setLength(int i4) {
            this.hasLength = true;
            this.length_ = i4;
            return this;
        }

        public MessageHead setName(String str) {
            this.hasName = true;
            this.name_ = str;
            return this;
        }

        public MessageHead setOffset(int i4) {
            this.hasOffset = true;
            this.offset_ = i4;
            return this;
        }

        @Override // L1.f
        public void writeTo(d dVar) throws IOException {
            if (hasOffset()) {
                dVar.s(1, getOffset());
            }
            if (hasLength()) {
                dVar.s(2, getLength());
            }
            if (hasName()) {
                dVar.A(3, getName());
            }
        }

        public static MessageHead parseFrom(byte[] bArr) throws e {
            return (MessageHead) new MessageHead().mergeFrom(bArr);
        }

        @Override // L1.f
        public MessageHead mergeFrom(b bVar) throws IOException {
            while (true) {
                int iO = bVar.o();
                if (iO == 0) {
                    return this;
                }
                if (iO == 8) {
                    setOffset(bVar.k());
                } else if (iO == 16) {
                    setLength(bVar.k());
                } else if (iO == 26) {
                    setName(bVar.n());
                } else if (!parseUnknownField(bVar, iO)) {
                    return this;
                }
            }
        }
    }

    public static RepHead parseFrom(b bVar) throws IOException {
        return new RepHead().mergeFrom(bVar);
    }

    public RepHead addMessageHead(MessageHead messageHead) {
        if (messageHead == null) {
            return this;
        }
        if (this.messageHead_.isEmpty()) {
            this.messageHead_ = new ArrayList();
        }
        this.messageHead_.add(messageHead);
        return this;
    }

    public final RepHead clear() {
        clearMd5();
        clearRange();
        clearMessageHead();
        this.cachedSize = -1;
        return this;
    }

    public RepHead clearMd5() {
        this.hasMd5 = false;
        this.md5_ = "";
        return this;
    }

    public RepHead clearMessageHead() {
        this.messageHead_ = Collections.emptyList();
        return this;
    }

    public RepHead clearRange() {
        this.hasRange = false;
        this.range_ = "";
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public String getMd5() {
        return this.md5_;
    }

    public MessageHead getMessageHead(int i4) {
        return this.messageHead_.get(i4);
    }

    public int getMessageHeadCount() {
        return this.messageHead_.size();
    }

    public List<MessageHead> getMessageHeadList() {
        return this.messageHead_;
    }

    public String getRange() {
        return this.range_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iL = hasMd5() ? d.l(1, getMd5()) : 0;
        if (hasRange()) {
            iL += d.l(2, getRange());
        }
        Iterator<MessageHead> it = getMessageHeadList().iterator();
        while (it.hasNext()) {
            iL += d.h(3, it.next());
        }
        this.cachedSize = iL;
        return iL;
    }

    public boolean hasMd5() {
        return this.hasMd5;
    }

    public boolean hasRange() {
        return this.hasRange;
    }

    public final boolean isInitialized() {
        return true;
    }

    public RepHead setMd5(String str) {
        this.hasMd5 = true;
        this.md5_ = str;
        return this;
    }

    public RepHead setMessageHead(int i4, MessageHead messageHead) {
        if (messageHead == null) {
            return this;
        }
        this.messageHead_.set(i4, messageHead);
        return this;
    }

    public RepHead setRange(String str) {
        this.hasRange = true;
        this.range_ = str;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasMd5()) {
            dVar.A(1, getMd5());
        }
        if (hasRange()) {
            dVar.A(2, getRange());
        }
        Iterator<MessageHead> it = getMessageHeadList().iterator();
        while (it.hasNext()) {
            dVar.u(3, it.next());
        }
    }

    public static RepHead parseFrom(byte[] bArr) throws e {
        return (RepHead) new RepHead().mergeFrom(bArr);
    }

    @Override // L1.f
    public RepHead mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setMd5(bVar.n());
            } else if (iO == 18) {
                setRange(bVar.n());
            } else if (iO == 26) {
                MessageHead messageHead = new MessageHead();
                bVar.f(messageHead);
                addMessageHead(messageHead);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
