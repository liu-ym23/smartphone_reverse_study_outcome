package com.bytedance.crypto.utils;

/* JADX INFO: loaded from: classes.dex */
public class CryptoConst {
    public static final String ALGORITHM_AES = "AES";
    public static final String ALGORITHM_CHACHA20 = "ChaCha20";
    public static final String ALGORITHM_CHACHA20_POLY1305 = "ChaCha20-Poly1305";
    public static final String ALGORITHM_EC = "EC";
    public static final String ALGORITHM_MD5 = "MD5";
    public static final String ALGORITHM_NONEwithECDSA = "NONEwithECDSA";
    public static final String ALGORITHM_SHA256 = "SHA-256";
    public static final int BITS_ECC_P256_KEY_LEN = 256;
    public static final int BITS_TAG_LEN = 128;
    public static final int BYTES_AES_KEY_LEN = 32;
    public static final int BYTES_CHACHA20_KEY_LEN = 32;
    public static final int BYTES_CIPHER_MAGIC_NUM = 315429581;
    public static final int BYTES_CIPHER_SHARED_MAGIC_NUM = -1412584499;
    public static final int BYTES_DIGEST_SHA256_LEN = 32;
    public static final int BYTES_IV_LEN = 12;
    public static final int BYTES_KEY_CIPHER_MAGIC_NUM = 317657839;
    public static final int BYTES_TAG_LEN = 16;
    public static final int BYTES_UNCOMPRESSED_EC_PUBLIC_KEY_LEN = 65;
    public static final int CERTIFICATE_MAX_SIZE = 32768;
    public static final int CIPHER_VERSION_1 = 1;
    public static final int CIPHER_VERSION_2 = 2;
    public static final int CURRENT_VERSION = 2;
    public static final int DECRYPT_BYTES_MAX_SIZE = 1048674;
    public static final int DECRYPT_STREAM_MAX_SIZE = 1074266130;
    public static final int ECC_SIGNATURE_MAX_SIZE = 128;
    public static final int ENCRYPT_BLOCK_MAX_SIZE = 1048576;
    public static final int ENCRYPT_BLOCK_SIZE = 4096;
    public static final int ENCRYPT_BLOCK_SIZE_32K = 32768;
    public static final int ENCRYPT_BYTES_MAX_SIZE = 1048576;
    public static final int ENCRYPT_STREAM_MAX_SIZE = 1073741824;
    public static final int INT_BYTE_LEN = 4;
    public static final int KEY_MANAGER_DECRYPT_MODE = 1;
    public static final int KEY_MANAGER_ENCRYPT_MODE = 0;
    public static final int STREAM_CIPHER_MAGIC_NUM = 313201323;
    public static final String TRANS_AES_DATA_AAD = "cloud_trans_data_v2";
    public static final String TRANS_AES_KEY_AAD = "cloud_trans_key_v2";
    public static final int TRANS_DATA_CIPHER_VERSION = 1;
    public static final int TRANS_DATA_MAGIC_NUM = 315433677;
    public static final int TRANS_FILE_FULL_CIPHER_MAGIC_NUM = 305424265;
    public static final int TRANS_FILE_FULL_KEY_MAGIC_NUM = 305419896;
    public static final int TRANS_FILE_PAGE_CIPHER_MAGIC_NUM = 591755408;
    public static final int TRANS_FILE_PAGE_KEY_MAGIC_NUM = 591751049;
    public static final int TRANS_KEY_CIPHER_MAGIC_NUM = 317666031;
    public static final int TRANS_KEY_CIPHER_VERSION = 1;
    public static final int TRANS_STREAM_CIPHER_MAGIC_NUM = 305441707;
    public static final int TRANS_STREAM_KEY_MAGIC_NUM = 305450445;

    public CryptoConst() {
    }
}
