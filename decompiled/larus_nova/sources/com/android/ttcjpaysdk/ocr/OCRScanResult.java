package com.android.ttcjpaysdk.ocr;

/* JADX INFO: loaded from: classes39.dex */
public class OCRScanResult {
    public int cardInputType;
    public String croppedImage;
    public byte[] data;
    public String text;

    public OCRScanResult(String r100, String r101, byte[] r102, int r103) {
        this.text = r100;
        this.croppedImage = r101;
        this.data = r102;
        this.cardInputType = r103;
    }
}
