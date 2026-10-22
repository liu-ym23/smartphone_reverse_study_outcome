package net.sqlcipher.database;

/* loaded from: classes5.dex */
public class SQLiteQueryStats {
    long largestIndividualRowSize;
    long totalQueryResultSize;

    public SQLiteQueryStats(long j10, long j11) {
        this.totalQueryResultSize = j10;
        this.largestIndividualRowSize = j11;
    }

    public long getLargestIndividualRowSize() {
        return this.largestIndividualRowSize;
    }

    public long getTotalQueryResultSize() {
        return this.totalQueryResultSize;
    }
}
