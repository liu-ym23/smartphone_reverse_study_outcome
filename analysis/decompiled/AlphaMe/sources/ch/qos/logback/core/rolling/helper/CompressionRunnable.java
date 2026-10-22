package ch.qos.logback.core.rolling.helper;

/* loaded from: classes.dex */
public class CompressionRunnable implements Runnable {
    final Compressor compressor;
    final String innerEntryName;
    final String nameOfCompressedFile;
    final String nameOfFile2Compress;

    public CompressionRunnable(Compressor compressor, String str, String str2, String str3) {
        this.compressor = compressor;
        this.nameOfFile2Compress = str;
        this.nameOfCompressedFile = str2;
        this.innerEntryName = str3;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        this.compressor.compress(this.nameOfFile2Compress, this.nameOfCompressedFile, this.innerEntryName);
    }
}
