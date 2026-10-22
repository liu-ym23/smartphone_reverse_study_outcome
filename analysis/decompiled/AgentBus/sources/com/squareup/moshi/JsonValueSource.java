package com.squareup.moshi;

import h4.n;
import ob.h;
import ob.j;
import ob.k;
import ob.k0;
import ob.m0;

/* loaded from: classes.dex */
final class JsonValueSource implements k0 {
    static final k STATE_C_STYLE_COMMENT;
    static final k STATE_DOUBLE_QUOTED;
    static final k STATE_END_OF_JSON;
    static final k STATE_END_OF_LINE_COMMENT;
    static final k STATE_JSON;
    static final k STATE_SINGLE_QUOTED;
    private final h buffer;
    private boolean closed;
    private long limit;
    private final h prefix;
    private final j source;
    private int stackSize;
    private k state;

    static {
        k kVar = k.f7997i;
        STATE_JSON = n.j("[]{}\"'/#");
        STATE_SINGLE_QUOTED = n.j("'\\");
        STATE_DOUBLE_QUOTED = n.j("\"\\");
        STATE_END_OF_LINE_COMMENT = n.j("\r\n");
        STATE_C_STYLE_COMMENT = n.j("*");
        STATE_END_OF_JSON = k.f7997i;
    }

    public JsonValueSource(j jVar) {
        this(jVar, new h(), STATE_JSON, 0);
    }

    private void advanceLimit(long j2) {
        while (true) {
            long j4 = this.limit;
            if (j4 >= j2) {
                return;
            }
            k kVar = this.state;
            k kVar2 = STATE_END_OF_JSON;
            if (kVar == kVar2) {
                return;
            }
            if (j4 == this.buffer.f7993g) {
                if (j4 > 0) {
                    return;
                } else {
                    this.source.L(1L);
                }
            }
            long jN = this.buffer.n(this.limit, this.state);
            if (jN == -1) {
                this.limit = this.buffer.f7993g;
            } else {
                byte bG = this.buffer.g(jN);
                k kVar3 = this.state;
                k kVar4 = STATE_JSON;
                if (kVar3 == kVar4) {
                    if (bG == 34) {
                        this.state = STATE_DOUBLE_QUOTED;
                        this.limit = jN + 1;
                    } else if (bG == 35) {
                        this.state = STATE_END_OF_LINE_COMMENT;
                        this.limit = jN + 1;
                    } else if (bG == 39) {
                        this.state = STATE_SINGLE_QUOTED;
                        this.limit = jN + 1;
                    } else if (bG != 47) {
                        if (bG != 91) {
                            if (bG != 93) {
                                if (bG != 123) {
                                    if (bG != 125) {
                                    }
                                }
                            }
                            int i2 = this.stackSize - 1;
                            this.stackSize = i2;
                            if (i2 == 0) {
                                this.state = kVar2;
                            }
                            this.limit = jN + 1;
                        }
                        this.stackSize++;
                        this.limit = jN + 1;
                    } else {
                        long j10 = 2 + jN;
                        this.source.L(j10);
                        long j11 = jN + 1;
                        byte bG2 = this.buffer.g(j11);
                        if (bG2 == 47) {
                            this.state = STATE_END_OF_LINE_COMMENT;
                            this.limit = j10;
                        } else if (bG2 == 42) {
                            this.state = STATE_C_STYLE_COMMENT;
                            this.limit = j10;
                        } else {
                            this.limit = j11;
                        }
                    }
                } else if (kVar3 == STATE_SINGLE_QUOTED || kVar3 == STATE_DOUBLE_QUOTED) {
                    if (bG == 92) {
                        long j12 = jN + 2;
                        this.source.L(j12);
                        this.limit = j12;
                    } else {
                        if (this.stackSize > 0) {
                            kVar2 = kVar4;
                        }
                        this.state = kVar2;
                        this.limit = jN + 1;
                    }
                } else if (kVar3 == STATE_C_STYLE_COMMENT) {
                    long j13 = 2 + jN;
                    this.source.L(j13);
                    long j14 = jN + 1;
                    if (this.buffer.g(j14) == 47) {
                        this.limit = j13;
                        this.state = kVar4;
                    } else {
                        this.limit = j14;
                    }
                } else {
                    if (kVar3 != STATE_END_OF_LINE_COMMENT) {
                        throw new AssertionError();
                    }
                    this.limit = jN + 1;
                    this.state = kVar4;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    public void discard() {
        this.closed = true;
        while (this.state != STATE_END_OF_JSON) {
            advanceLimit(8192L);
            this.source.skip(this.limit);
        }
    }

    @Override // ob.k0
    public long read(h hVar, long j2) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (j2 == 0) {
            return 0L;
        }
        if (!this.prefix.e()) {
            long j4 = this.prefix.read(hVar, j2);
            long j10 = j2 - j4;
            if (!this.buffer.e()) {
                long j11 = read(hVar, j10);
                if (j11 != -1) {
                    return j11 + j4;
                }
            }
            return j4;
        }
        advanceLimit(j2);
        long j12 = this.limit;
        if (j12 == 0) {
            if (this.state == STATE_END_OF_JSON) {
                return -1L;
            }
            throw new AssertionError();
        }
        long jMin = Math.min(j2, j12);
        hVar.write(this.buffer, jMin);
        this.limit -= jMin;
        return jMin;
    }

    @Override // ob.k0
    public m0 timeout() {
        return this.source.timeout();
    }

    public JsonValueSource(j jVar, h hVar, k kVar, int i2) {
        this.limit = 0L;
        this.closed = false;
        this.source = jVar;
        this.buffer = jVar.c();
        this.prefix = hVar;
        this.state = kVar;
        this.stackSize = i2;
    }
}
